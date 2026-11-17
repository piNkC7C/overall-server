package cn.iocoder.yudao.module.bpm.framework.flowable.config;

import cn.hutool.core.collection.CollUtil;
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
import cn.iocoder.yudao.module.bpm.framework.flowable.core.enums.BpmTaskCandidateStrategyEnum;
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
 * CRM 合同/回款审批流程模型初始化：
 * <ul>
 *   <li>全员可发起（startUserIds / startDeptIds 为空）</li>
 *   <li>{@code crm_admin} 角色审批</li>
 *   <li>抄送 {@code super_admin}、{@code admin}</li>
 * </ul>
 *
 * 幂等：已存在激活流程定义则跳过；仅有模型未部署则补部署。
 */
@Component
@Order(200)
@Slf4j
public class CrmBpmModelInitializer implements ApplicationRunner {

    public static final String CATEGORY_CODE = "CRM";
    public static final String CONTRACT_KEY = "crm-contract-audit";
    public static final String RECEIVABLE_KEY = "crm-receivable-audit";

    private static final Long FALLBACK_MANAGER_USER_ID = 1L;

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
        if (CollUtil.isEmpty(roleIds.copyRoleIds())) {
            log.warn("[initTenant][缺少 super_admin/admin 角色，跳过抄送配置相关模型初始化]");
            return;
        }
        List<Long> managerUserIds = resolveManagerUserIds(roleIds);
        ensureModel(CONTRACT_KEY, "合同审批",
                "/crm/contract", "/crm/contract/detail/index.vue",
                roleIds, managerUserIds);
        ensureModel(RECEIVABLE_KEY, "回款审批",
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
        // 角色已存在时直接解析；admin / crm_admin 缺失时按编码补建（super_admin 为内置，不可创建）
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

        Long approveRoleId = roleMap.containsKey(RoleCodeEnum.CRM_ADMIN.getCode())
                ? roleMap.get(RoleCodeEnum.CRM_ADMIN.getCode()).getId() : null;
        List<Long> copyRoleIds = new ArrayList<>(2);
        if (roleMap.containsKey(RoleCodeEnum.SUPER_ADMIN.getCode())) {
            copyRoleIds.add(roleMap.get(RoleCodeEnum.SUPER_ADMIN.getCode()).getId());
        }
        if (roleMap.containsKey(RoleCodeEnum.ADMIN.getCode())) {
            copyRoleIds.add(roleMap.get(RoleCodeEnum.ADMIN.getCode()).getId());
        }
        return new RoleIds(approveRoleId, copyRoleIds);
    }

    private List<Long> resolveManagerUserIds(RoleIds roleIds) {
        List<Long> managerRoleIds = new ArrayList<>(roleIds.copyRoleIds());
        if (roleIds.approveRoleId() != null) {
            managerRoleIds.add(roleIds.approveRoleId());
        }
        Set<Long> userIds = permissionApi.getUserRoleIdListByRoleIds(managerRoleIds).getCheckedData();
        if (CollUtil.isNotEmpty(userIds)) {
            return new ArrayList<>(userIds);
        }
        return Collections.singletonList(FALLBACK_MANAGER_USER_ID);
    }

    private void ensureModel(String key, String name, String createPath, String viewPath,
                             RoleIds roleIds, List<Long> managerUserIds) {
        ProcessDefinition active = processDefinitionService.getActiveProcessDefinition(key);
        if (active != null) {
            return;
        }
        Model model = repositoryService.createModelQuery()
                .modelTenantId(FlowableUtils.getTenantId())
                .modelKey(key)
                .singleResult();
        if (model == null) {
            BpmModelSaveReqVO reqVO = buildModelReq(key, name, createPath, viewPath, roleIds, managerUserIds);
            String modelId = modelService.createModel(reqVO);
            modelService.deployModel(managerUserIds.get(0), modelId);
            log.info("[ensureModel][已创建并部署 CRM 流程 key={}]", key);
            return;
        }
        Long deployerUserId = resolveDeployerUserId(model, managerUserIds);
        modelService.deployModel(deployerUserId, model.getId());
        log.info("[ensureModel][已补部署 CRM 流程 key={}]", key);
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

        BpmSimpleModelNodeVO copyNode = new BpmSimpleModelNodeVO()
                .setId("copy")
                .setName("抄送")
                .setType(BpmSimpleModelNodeTypeEnum.COPY_NODE.getType())
                .setCandidateStrategy(BpmTaskCandidateStrategyEnum.ROLE.getStrategy())
                .setCandidateParam(CollUtil.join(roleIds.copyRoleIds(), ","))
                .setChildNode(endNode);

        BpmSimpleModelNodeVO approveNode = new BpmSimpleModelNodeVO()
                .setId("approve")
                .setName("审批")
                .setType(BpmSimpleModelNodeTypeEnum.APPROVE_NODE.getType())
                .setApproveType(BpmUserTaskApproveTypeEnum.USER.getType())
                .setApproveMethod(BpmUserTaskApproveMethodEnum.ANY.getMethod())
                .setCandidateStrategy(BpmTaskCandidateStrategyEnum.ROLE.getStrategy())
                .setCandidateParam(String.valueOf(roleIds.approveRoleId()))
                .setChildNode(copyNode);

        BpmSimpleModelNodeVO startUserNode = new BpmSimpleModelNodeVO()
                .setId("start-user")
                .setName("发起人")
                .setType(BpmSimpleModelNodeTypeEnum.START_USER_NODE.getType())
                .setChildNode(approveNode);

        BpmModelSaveReqVO reqVO = new BpmModelSaveReqVO();
        reqVO.setKey(key);
        reqVO.setName(name);
        reqVO.setCategory(CATEGORY_CODE);
        reqVO.setType(BpmModelTypeEnum.SIMPLE.getType());
        reqVO.setFormType(BpmModelFormTypeEnum.CUSTOM.getType());
        reqVO.setFormCustomCreatePath(createPath);
        reqVO.setFormCustomViewPath(viewPath);
        reqVO.setVisible(false); // CRM 业务页提交，不在流程发起列表展示
        // startUserIds / startDeptIds 为空 = 全员可发起
        reqVO.setManagerUserIds(managerUserIds);
        reqVO.setSimpleModel(startUserNode);
        return reqVO;
    }

    private record RoleIds(Long approveRoleId, List<Long> copyRoleIds) {
    }

}
