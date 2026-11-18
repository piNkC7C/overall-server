package cn.iocoder.yudao.module.bpm.framework.flowable.config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.biz.system.tenant.TenantCommonApi;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.tenant.core.util.TenantUtils;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.category.BpmCategorySaveReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model.BpmModelMetaInfoVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model.BpmModelSaveReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model.simple.BpmSimpleModelNodeVO;
import cn.iocoder.yudao.module.bpm.convert.definition.BpmModelConvert;
import cn.iocoder.yudao.module.bpm.enums.definition.BpmModelFormTypeEnum;
import cn.iocoder.yudao.module.bpm.enums.definition.BpmModelTypeEnum;
import cn.iocoder.yudao.module.bpm.enums.definition.BpmSimpleModelNodeTypeEnum;
import cn.iocoder.yudao.module.bpm.enums.definition.BpmUserTaskApproveMethodEnum;
import cn.iocoder.yudao.module.bpm.enums.definition.BpmUserTaskApproveTypeEnum;
import cn.iocoder.yudao.module.bpm.enums.definition.BpmUserTaskAssignEmptyHandlerTypeEnum;
import cn.iocoder.yudao.module.bpm.enums.definition.BpmUserTaskAssignStartUserHandlerTypeEnum;
import cn.iocoder.yudao.module.bpm.enums.definition.BpmUserTaskRejectHandlerTypeEnum;
import cn.iocoder.yudao.module.bpm.enums.definition.BpmUserTaskTimeoutHandlerTypeEnum;
import cn.iocoder.yudao.module.bpm.framework.flowable.core.enums.BpmTaskCandidateStrategyEnum;
import cn.iocoder.yudao.module.bpm.framework.flowable.core.enums.BpmnModelConstants;
import cn.iocoder.yudao.module.bpm.framework.flowable.core.util.FlowableUtils;
import cn.iocoder.yudao.module.bpm.service.definition.BpmCategoryService;
import cn.iocoder.yudao.module.bpm.service.definition.BpmModelService;
import cn.iocoder.yudao.module.bpm.service.definition.BpmProcessDefinitionService;
import cn.iocoder.yudao.module.system.api.permission.PermissionApi;
import cn.iocoder.yudao.module.system.api.permission.RoleApi;
import cn.iocoder.yudao.module.system.api.permission.dto.RoleRespDTO;
import cn.iocoder.yudao.module.system.enums.permission.RoleCodeEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Model;
import org.flowable.engine.repository.ProcessDefinition;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * CRM 合同/回款审批流程模型初始化（对齐 ERP glks-admin 现网结构）：
 * <ul>
 *   <li>发起人 → 并行分支（审批人 ‖ 抄送人）→ 结束</li>
 *   <li>审批：{@code crm_admin} 角色</li>
 *   <li>抄送：指定成员 admin（用户 1）</li>
 * </ul>
 */
@Component
@Order(200)
@Slf4j
public class CrmBpmModelInitializer implements ApplicationRunner {

    public static final String CATEGORY_CODE = "CRM";
    public static final String CONTRACT_KEY = "crm-contract-audit";
    public static final String RECEIVABLE_KEY = "crm-receivable-audit";

    private static final Long FALLBACK_MANAGER_USER_ID = 1L;
    /** 与 ERP 一致：抄送给系统管理员 */
    private static final Long COPY_USER_ID = 1L;
    private static final String COPY_USER_SHOW_NAME = "Admin";

    private static final int BTN_APPROVE = 1;
    private static final int BTN_REJECT = 2;
    private static final int BTN_TRANSFER = 3;
    private static final int BTN_DELEGATE = 4;
    private static final int BTN_ADD_SIGN = 5;
    private static final int BTN_RETURN = 6;

    @Resource
    private TenantCommonApi tenantCommonApi;
    @Resource
    private RoleApi roleApi;
    @Resource
    private PermissionApi permissionApi;
    @Resource
    private BpmCategoryService categoryService;
    @Resource
    private BpmModelService modelService;
    @Resource
    private BpmProcessDefinitionService processDefinitionService;
    @Resource
    private RepositoryService repositoryService;

    @Override
    public void run(ApplicationArguments args) {
        List<Long> tenantIds;
        try {
            tenantIds = tenantCommonApi.getTenantIdList().getCheckedData();
        } catch (Exception ex) {
            log.warn("[run][跳过 CRM BPM 模型初始化，获取租户列表失败]", ex);
            return;
        }
        if (CollUtil.isEmpty(tenantIds)) {
            return;
        }
        for (Long tenantId : tenantIds) {
            try {
                TenantUtils.execute(tenantId, this::initTenant);
            } catch (Exception ex) {
                log.warn("[run][租户({}) CRM BPM 模型初始化失败]", tenantId, ex);
            }
        }
    }

    private void initTenant() {
        ensureCategory();
        RoleIds roleIds = resolveRoleIds();
        if (roleIds.approveRoleId() == null) {
            log.warn("[initTenant][缺少 crm_admin 角色，跳过 CRM 审批模型初始化]");
            return;
        }
        List<Long> managerUserIds = resolveManagerUserIds(roleIds);
        // 流程名用英文：站内信占位符 + glossary-zh（合同审批 / 回款审批）
        ensureModel(CONTRACT_KEY, "Contract approval",
                "/crm/contract", "/crm/contract/detail/index.vue",
                roleIds, managerUserIds);
        ensureModel(RECEIVABLE_KEY, "Payment approval",
                "/crm/receivable", "/crm/receivable/detail/index.vue",
                roleIds, managerUserIds);
    }

    private void ensureCategory() {
        if (CollUtil.isNotEmpty(categoryService.getCategoryListByCode(Collections.singleton(CATEGORY_CODE)))) {
            return;
        }
        BpmCategorySaveReqVO reqVO = new BpmCategorySaveReqVO();
        reqVO.setName("CRM");
        reqVO.setCode(CATEGORY_CODE);
        reqVO.setDescription("CRM approval processes");
        reqVO.setStatus(CommonStatusEnum.ENABLE.getStatus());
        reqVO.setSort(10);
        categoryService.createCategory(reqVO);
        log.info("[ensureCategory][已创建流程分类 code={}]", CATEGORY_CODE);
    }

    private RoleIds resolveRoleIds() {
        roleApi.createRoleIfAbsent(RoleCodeEnum.ADMIN.getCode(), RoleCodeEnum.ADMIN.getName()).checkError();
        roleApi.createRoleIfAbsent(RoleCodeEnum.CRM_ADMIN.getCode(), RoleCodeEnum.CRM_ADMIN.getName()).checkError();

        List<String> codes = Arrays.asList(
                RoleCodeEnum.SUPER_ADMIN.getCode(),
                RoleCodeEnum.ADMIN.getCode(),
                RoleCodeEnum.CRM_ADMIN.getCode());
        Map<String, RoleRespDTO> roleMap = roleApi.getRoleListByCodes(codes).getCheckedData().stream()
                .filter(Objects::nonNull)
                .filter(role -> StrUtil.isNotBlank(role.getCode()))
                .collect(Collectors.toMap(RoleRespDTO::getCode, Function.identity(), (a, b) -> a));

        RoleRespDTO approveRole = roleMap.get(RoleCodeEnum.CRM_ADMIN.getCode());
        Long approveRoleId = approveRole != null ? approveRole.getId() : null;
        String approveRoleName = approveRole != null ? approveRole.getName() : null;

        List<Long> managerRoleIds = new ArrayList<>(3);
        for (String code : codes) {
            RoleRespDTO role = roleMap.get(code);
            if (role != null) {
                managerRoleIds.add(role.getId());
            }
        }
        return new RoleIds(approveRoleId, approveRoleName, managerRoleIds);
    }

    private List<Long> resolveManagerUserIds(RoleIds roleIds) {
        if (CollUtil.isEmpty(roleIds.managerRoleIds())) {
            return Collections.singletonList(FALLBACK_MANAGER_USER_ID);
        }
        Set<Long> userIds = permissionApi.getUserRoleIdListByRoleIds(roleIds.managerRoleIds()).getCheckedData();
        if (CollUtil.isNotEmpty(userIds)) {
            return new ArrayList<>(userIds);
        }
        return Collections.singletonList(FALLBACK_MANAGER_USER_ID);
    }

    private void ensureModel(String key, String name, String createPath, String viewPath,
                             RoleIds roleIds, List<Long> managerUserIds) {
        Model model = repositoryService.createModelQuery()
                .modelTenantId(FlowableUtils.getTenantId())
                .modelKey(key)
                .singleResult();
        ProcessDefinition active = processDefinitionService.getActiveProcessDefinition(key);
        BpmModelSaveReqVO reqVO = buildModelReq(key, name, createPath, viewPath, roleIds, managerUserIds);

        if (model == null) {
            String modelId = modelService.createModel(reqVO);
            modelService.deployModel(managerUserIds.get(0), modelId);
            log.info("[ensureModel][已创建并部署 CRM 流程 key={}]", key);
            return;
        }

        Long deployerUserId = resolveDeployerUserId(model, managerUserIds);
        BpmSimpleModelNodeVO existing = null;
        try {
            existing = modelService.getSimpleModel(model.getId());
        } catch (Exception ex) {
            log.warn("[ensureModel][读取 simpleModel 失败 key={}]", key, ex);
        }

        boolean incomplete = isSimpleModelIncomplete(existing);
        if (!incomplete && active != null) {
            return;
        }

        reqVO.setId(model.getId());
        try {
            modelService.updateModel(deployerUserId, reqVO);
            modelService.deployModel(deployerUserId, model.getId());
            log.info("[ensureModel][已按并行结构补全并重新部署 CRM 流程 key={} incomplete={}]", key, incomplete);
        } catch (Exception ex) {
            log.warn("[ensureModel][补全/部署 CRM 流程失败 key={}]", key, ex);
            if (active == null) {
                try {
                    modelService.deployModel(deployerUserId, model.getId());
                    log.info("[ensureModel][已补部署 CRM 流程 key={}]", key);
                } catch (Exception deployEx) {
                    log.warn("[ensureModel][补部署仍失败 key={}]", key, deployEx);
                }
            }
        }
    }

    /**
     * 必须为：发起人 → 并行分支（含审批+抄送）→ 结束；否则视为不完整（含旧串行结构）。
     */
    private boolean isSimpleModelIncomplete(BpmSimpleModelNodeVO node) {
        if (node == null) {
            return true;
        }
        if (!Objects.equals(node.getType(), BpmSimpleModelNodeTypeEnum.START_USER_NODE.getType())) {
            return true;
        }
        BpmSimpleModelNodeVO parallel = node.getChildNode();
        if (parallel == null
                || !Objects.equals(parallel.getType(), BpmSimpleModelNodeTypeEnum.PARALLEL_BRANCH_NODE.getType())
                || CollUtil.isEmpty(parallel.getConditionNodes())
                || parallel.getConditionNodes().size() < 2) {
            return true;
        }
        boolean hasApprove = false;
        boolean hasCopy = false;
        for (BpmSimpleModelNodeVO branch : parallel.getConditionNodes()) {
            BpmSimpleModelNodeVO leaf = branch != null ? branch.getChildNode() : null;
            if (leaf == null) {
                continue;
            }
            if (Objects.equals(leaf.getType(), BpmSimpleModelNodeTypeEnum.APPROVE_NODE.getType())) {
                hasApprove = true;
            }
            if (Objects.equals(leaf.getType(), BpmSimpleModelNodeTypeEnum.COPY_NODE.getType())) {
                hasCopy = true;
            }
        }
        return !(hasApprove && hasCopy);
    }

    private Long resolveDeployerUserId(Model model, List<Long> fallbackManagerUserIds) {
        BpmModelMetaInfoVO metaInfo = BpmModelConvert.INSTANCE.parseMetaInfo(model);
        if (metaInfo != null && CollUtil.isNotEmpty(metaInfo.getManagerUserIds())) {
            return metaInfo.getManagerUserIds().get(0);
        }
        return CollUtil.getFirst(fallbackManagerUserIds);
    }

    private BpmModelSaveReqVO buildModelReq(String key, String name, String createPath, String viewPath,
                                            RoleIds roleIds, List<Long> managerUserIds) {
        BpmSimpleModelNodeVO endNode = new BpmSimpleModelNodeVO()
                .setId("EndEvent")
                .setName(BpmSimpleModelNodeTypeEnum.END_NODE.getName())
                .setType(BpmSimpleModelNodeTypeEnum.END_NODE.getType());

        // 并行分支 1：审批人（角色 CSO）
        BpmSimpleModelNodeVO.RejectHandler rejectHandler = new BpmSimpleModelNodeVO.RejectHandler();
        rejectHandler.setType(BpmUserTaskRejectHandlerTypeEnum.RETURN_USER_TASK.getType());
        rejectHandler.setReturnNodeId(BpmnModelConstants.START_USER_NODE_ID);

        BpmSimpleModelNodeVO.TimeoutHandler timeoutHandler = new BpmSimpleModelNodeVO.TimeoutHandler();
        timeoutHandler.setEnable(true);
        timeoutHandler.setType(BpmUserTaskTimeoutHandlerTypeEnum.REMINDER.getType());
        timeoutHandler.setTimeDuration("P1D");
        timeoutHandler.setMaxRemindCount(3);

        BpmSimpleModelNodeVO.AssignEmptyHandler assignEmptyHandler = new BpmSimpleModelNodeVO.AssignEmptyHandler();
        assignEmptyHandler.setType(BpmUserTaskAssignEmptyHandlerTypeEnum.APPROVE.getType());

        BpmSimpleModelNodeVO approveNode = new BpmSimpleModelNodeVO()
                .setId("Activity_" + IdUtil.fastSimpleUUID())
                .setName("Approver")
                .setType(BpmSimpleModelNodeTypeEnum.APPROVE_NODE.getType())
                .setApproveType(BpmUserTaskApproveTypeEnum.USER.getType())
                .setApproveMethod(BpmUserTaskApproveMethodEnum.ANY.getMethod())
                .setCandidateStrategy(BpmTaskCandidateStrategyEnum.ROLE.getStrategy())
                .setCandidateParam(String.valueOf(roleIds.approveRoleId()))
                .setShowText("Specified roles: " + StrUtil.blankToDefault(roleIds.approveRoleName(), "CSO"))
                .setRejectHandler(rejectHandler)
                .setTimeoutHandler(timeoutHandler)
                .setAssignStartUserHandlerType(BpmUserTaskAssignStartUserHandlerTypeEnum.START_USER_AUDIT.getType())
                .setAssignEmptyHandler(assignEmptyHandler)
                .setButtonsSetting(defaultApproveButtons())
                .setSignEnable(false)
                .setReasonRequire(false)
                .setSkipExpression("");

        BpmSimpleModelNodeVO approveBranch = new BpmSimpleModelNodeVO()
                .setId("Flow_" + IdUtil.fastSimpleUUID())
                .setName("并行1")
                .setType(BpmSimpleModelNodeTypeEnum.CONDITION_NODE.getType())
                .setShowText("Run in parallel, no condition needed")
                .setChildNode(approveNode);

        // 并行分支 2：抄送人（指定成员 Admin），与审批并行
        BpmSimpleModelNodeVO copyNode = new BpmSimpleModelNodeVO()
                .setId("Activity_" + IdUtil.fastSimpleUUID())
                .setName("Cc")
                .setType(BpmSimpleModelNodeTypeEnum.COPY_NODE.getType())
                .setCandidateStrategy(BpmTaskCandidateStrategyEnum.USER.getStrategy())
                .setCandidateParam(String.valueOf(COPY_USER_ID))
                .setShowText("Specified members: " + COPY_USER_SHOW_NAME);

        BpmSimpleModelNodeVO copyBranch = new BpmSimpleModelNodeVO()
                .setId("Flow_" + IdUtil.fastSimpleUUID())
                .setName("并行2")
                .setType(BpmSimpleModelNodeTypeEnum.CONDITION_NODE.getType())
                .setShowText("Run in parallel, no condition needed")
                .setChildNode(copyNode);

        BpmSimpleModelNodeVO parallelNode = new BpmSimpleModelNodeVO()
                .setId("GateWay_" + IdUtil.fastSimpleUUID())
                .setName("并行分支")
                .setType(BpmSimpleModelNodeTypeEnum.PARALLEL_BRANCH_NODE.getType())
                .setConditionNodes(Arrays.asList(approveBranch, copyBranch))
                .setChildNode(endNode);

        BpmSimpleModelNodeVO startUserNode = new BpmSimpleModelNodeVO()
                .setId(BpmnModelConstants.START_USER_NODE_ID)
                .setName("Starter")
                .setType(BpmSimpleModelNodeTypeEnum.START_USER_NODE.getType())
                .setShowText("Configured")
                .setButtonsSetting(defaultStartUserButtons())
                .setChildNode(parallelNode);

        BpmModelSaveReqVO reqVO = new BpmModelSaveReqVO();
        reqVO.setKey(key);
        reqVO.setName(name);
        reqVO.setCategory(CATEGORY_CODE);
        reqVO.setType(BpmModelTypeEnum.SIMPLE.getType());
        reqVO.setFormType(BpmModelFormTypeEnum.CUSTOM.getType());
        reqVO.setFormCustomCreatePath(createPath);
        reqVO.setFormCustomViewPath(viewPath);
        reqVO.setVisible(false);
        reqVO.setManagerUserIds(managerUserIds);
        reqVO.setSimpleModel(startUserNode);
        return reqVO;
    }

    private static List<BpmSimpleModelNodeVO.OperationButtonSetting> defaultApproveButtons() {
        return Arrays.asList(
                button(BTN_APPROVE, "Approve", true),
                button(BTN_REJECT, "Reject", true),
                button(BTN_TRANSFER, "Transfer task", true),
                button(BTN_DELEGATE, "Delegate task", true),
                button(BTN_ADD_SIGN, "Countersign", true),
                button(BTN_RETURN, "Return task", true));
    }

    private static List<BpmSimpleModelNodeVO.OperationButtonSetting> defaultStartUserButtons() {
        return Arrays.asList(
                button(BTN_APPROVE, "Submit", true),
                button(BTN_REJECT, "Reject", false),
                button(BTN_TRANSFER, "Transfer task", false),
                button(BTN_DELEGATE, "Delegate task", false),
                button(BTN_ADD_SIGN, "Countersign", false),
                button(BTN_RETURN, "Return task", false));
    }

    private static BpmSimpleModelNodeVO.OperationButtonSetting button(int id, String name, boolean enable) {
        BpmSimpleModelNodeVO.OperationButtonSetting setting = new BpmSimpleModelNodeVO.OperationButtonSetting();
        setting.setId(id);
        setting.setDisplayName(name);
        setting.setEnable(enable);
        return setting;
    }

    private record RoleIds(Long approveRoleId, String approveRoleName, List<Long> managerRoleIds) {
    }

}
