package cn.iocoder.yudao.module.mes.controller.admin.pro.feedback;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.pro.feedback.vo.MesProFeedbackPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.pro.feedback.vo.MesProFeedbackRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.pro.feedback.vo.MesProFeedbackSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.item.MesMdItemDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.unitmeasure.MesMdUnitMeasureDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.workstation.MesMdWorkstationDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.pro.feedback.MesProFeedbackDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.pro.process.MesProProcessDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.pro.route.MesProRouteDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.pro.route.MesProRouteProcessDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.pro.task.MesProTaskDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.pro.workorder.MesProWorkOrderDO;
import cn.iocoder.yudao.module.mes.service.md.item.MesMdItemService;
import cn.iocoder.yudao.module.mes.service.md.unitmeasure.MesMdUnitMeasureService;
import cn.iocoder.yudao.module.mes.service.md.workstation.MesMdWorkstationService;
import cn.iocoder.yudao.module.mes.service.pro.feedback.MesProFeedbackService;
import cn.iocoder.yudao.module.mes.service.pro.process.MesProProcessService;
import cn.iocoder.yudao.module.mes.service.pro.route.MesProRouteProcessService;
import cn.iocoder.yudao.module.mes.service.pro.route.MesProRouteService;
import cn.iocoder.yudao.module.mes.service.pro.task.MesProTaskService;
import cn.iocoder.yudao.module.mes.service.pro.workorder.MesProWorkOrderService;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.*;
import static cn.iocoder.yudao.framework.common.util.collection.MapUtils.findAndThen;


@Tag(name = "Admin - MES production work report.")
@RestController
@RequestMapping("/mes/pro/feedback")
@Validated
public class MesProFeedbackController {

    @Resource
    private MesProFeedbackService feedbackService;
    @Resource
    private MesMdWorkstationService workstationService;
    @Resource
    private MesProRouteService routeService;
    @Resource
    private MesProProcessService processService;
    @Resource
    private MesProWorkOrderService workOrderService;
    @Resource
    private MesMdItemService itemService;
    @Resource
    private MesMdUnitMeasureService unitMeasureService;
    @Resource
    private MesProRouteProcessService routeProcessService;
    @Resource
    private MesProTaskService taskService;

    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "Create production work report.")
    @PreAuthorize("@ss.hasPermission('mes:pro-feedback:create')")
    public CommonResult<Long> createFeedback(@Valid @RequestBody MesProFeedbackSaveReqVO createReqVO) {
        return success(feedbackService.createFeedback(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update production work report.")
    @PreAuthorize("@ss.hasPermission('mes:pro-feedback:update')")
    public CommonResult<Boolean> updateFeedback(@Valid @RequestBody MesProFeedbackSaveReqVO updateReqVO) {
        feedbackService.updateFeedback(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete production work report.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:pro-feedback:delete')")
    public CommonResult<Boolean> deleteFeedback(@RequestParam("id") Long id) {
        feedbackService.deleteFeedback(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get production work report.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:pro-feedback:query')")
    public CommonResult<MesProFeedbackRespVO> getFeedback(@RequestParam("id") Long id) {
        MesProFeedbackDO feedback = feedbackService.getFeedback(id);
        if (feedback == null) {
            return success(null);
        }
        return success(buildFeedbackRespVOList(ListUtil.of(feedback)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get production work report page.")
    @PreAuthorize("@ss.hasPermission('mes:pro-feedback:query')")
    public CommonResult<PageResult<MesProFeedbackRespVO>> getFeedbackPage(@Valid MesProFeedbackPageReqVO pageReqVO) {
        PageResult<MesProFeedbackDO> pageResult = feedbackService.getFeedbackPage(pageReqVO);
        return success(new PageResult<>(buildFeedbackRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export production work report Excel.")
    @PreAuthorize("@ss.hasPermission('mes:pro-feedback:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportFeedbackExcel(@Valid MesProFeedbackPageReqVO pageReqVO,
                                     HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesProFeedbackDO> list = feedbackService.getFeedbackPage(pageReqVO).getList();
        List<MesProFeedbackRespVO> voList = buildFeedbackRespVOList(list);
        ExcelUtils.write(response, "Production Feedback.xls", "Data", MesProFeedbackRespVO.class, voList);
    }

    @PutMapping("/submit")
    @Operation(summary = "Submit work report.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:pro-feedback:update')")
    public CommonResult<Boolean> submitFeedback(@RequestParam("id") Long id) {
        feedbackService.submitFeedback(id);
        return success(true);
    }

    @PutMapping("/reject")
    @Operation(summary = "Reject work report.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:pro-feedback:update')")
    public CommonResult<Boolean> rejectFeedback(@RequestParam("id") Long id) {
        feedbackService.rejectFeedback(id);
        return success(true);
    }

    @PutMapping("/approve")
    @Operation(summary = "Approval work report.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:pro-feedback:approve')")
    public CommonResult<Boolean> approveFeedback(@RequestParam("id") Long id) {
        return success(feedbackService.approveFeedback(id));
    }

    // ==================== 拼接 VO ====================

    private List<MesProFeedbackRespVO> buildFeedbackRespVOList(List<MesProFeedbackDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1.1 task ( get taskCode)
        Map<Long, MesProTaskDO> taskMap = taskService.getTaskMap(
                convertSet(list, MesProFeedbackDO::getTaskId));
        // 1.2 material ( directly from DO.itemId)、 unit of measure ( from item.unitMeasureId)
        Map<Long, MesMdItemDO> itemMap = itemService.getItemMap(
                convertSet(list, MesProFeedbackDO::getItemId));
        Map<Long, MesMdUnitMeasureDO> unitMeasureMap = unitMeasureService.getUnitMeasureMap(
                convertSet(itemMap.values(), MesMdItemDO::getUnitMeasureId));
        // 1.3 work order
        Map<Long, MesProWorkOrderDO> workOrderMap = workOrderService.getWorkOrderMap(
                convertSet(list, MesProFeedbackDO::getWorkOrderId));
        // 1.4 workstation
        Map<Long, MesMdWorkstationDO> workstationMap = workstationService.getWorkstationMap(
                convertSet(list, MesProFeedbackDO::getWorkstationId));
        // 1.5 routing path
        Set<Long> routeIds = convertSet(list, MesProFeedbackDO::getRouteId);
        Map<Long, MesProRouteDO> routeMap = routeService.getRouteMap(routeIds);
        // 1.6 operation
        Map<Long, MesProProcessDO> processMap = processService.getProcessMap(
                new ArrayList<>(convertSet(list, MesProFeedbackDO::getProcessId)));
        // 1.7 工序的 checkFlag：批量查询后直接构建 routeId -> processId -> checkFlag 的双层 Map
        List<MesProRouteProcessDO> allRouteProcesses = routeProcessService.getRouteProcessListByRouteIds(routeIds);
        Map<Long, Map<Long, Boolean>> routeProcessCheckFlagMap = new HashMap<>();
        for (MesProRouteProcessDO rp : allRouteProcesses) {
            routeProcessCheckFlagMap
                    .computeIfAbsent(rp.getRouteId(), k -> new HashMap<>())
                    .put(rp.getProcessId(), Boolean.TRUE.equals(rp.getCheckFlag()));
        }
        // 1.8 work report person / approval person
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSetByFlatMap(list, feedback ->
                        Stream.of(feedback.getFeedbackUserId(), feedback.getApproveUserId())));

        // 2. 拼接 VO
        return BeanUtils.toBean(list, MesProFeedbackRespVO.class, vo -> {
            // Workstation
            findAndThen(workstationMap, vo.getWorkstationId(), ws ->
                    vo.setWorkstationCode(ws.getCode()).setWorkstationName(ws.getName()));
            // Routing path
            findAndThen(routeMap, vo.getRouteId(), route ->
                    vo.setRouteCode(route.getCode()));
            // Operation
            findAndThen(processMap, vo.getProcessId(), process ->
                    vo.setProcessCode(process.getCode()).setProcessName(process.getName()));
            // checkFlag
            findAndThen(routeProcessCheckFlagMap, vo.getRouteId(), processCheckMap ->
                    findAndThen(processCheckMap, vo.getProcessId(), vo::setCheckFlag));
            // Work order
            findAndThen(workOrderMap, vo.getWorkOrderId(), wo ->
                    vo.setWorkOrderCode(wo.getCode()).setWorkOrderName(wo.getName()));
            // Task
            findAndThen(taskMap, vo.getTaskId(), task ->
                    vo.setTaskCode(task.getCode()));
            // Material → order characters
            findAndThen(itemMap, vo.getItemId(), item -> {
                vo.setItemCode(item.getCode()).setItemName(item.getName()).setItemSpecification(item.getSpecification())
                        .setUnitMeasureId(item.getUnitMeasureId());
                findAndThen(unitMeasureMap, item.getUnitMeasureId(), unit ->
                        vo.setUnitMeasureName(unit.getName()));
            });
            // Work report person 、 approval person
            findAndThen(userMap, vo.getFeedbackUserId(), user ->
                    vo.setFeedbackUserNickname(user.getNickname()));
            findAndThen(userMap, vo.getApproveUserId(), user ->
                    vo.setApproveUserNickname(user.getNickname()));
        });
    }

}
