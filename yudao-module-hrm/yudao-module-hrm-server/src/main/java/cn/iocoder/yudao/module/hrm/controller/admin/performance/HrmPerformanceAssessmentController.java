package cn.iocoder.yudao.module.hrm.controller.admin.performance;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee.HrmEmployeeListReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment.HrmPerformanceArchiveEmployeePageReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment.HrmPerformanceArchiveEmployeeRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment.HrmPerformanceArchivePageReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment.HrmPerformanceAssessmentBatchReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment.HrmPerformanceAssessmentPageReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment.HrmPerformanceAssessmentRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment.HrmPerformanceProcessRecordRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.plan.HrmPerformancePlanRespVO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.employee.info.HrmEmployeeDO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.performance.assessment.HrmPerformanceAssessmentDO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.performance.plan.HrmPerformancePlanDO;
import cn.iocoder.yudao.module.hrm.enums.performance.plan.HrmPerformancePlanStatusEnum;
import cn.iocoder.yudao.module.hrm.service.employee.info.HrmEmployeeService;
import cn.iocoder.yudao.module.hrm.service.performance.assessment.HrmPerformanceAssessmentProcessService;
import cn.iocoder.yudao.module.hrm.service.performance.assessment.HrmPerformanceAssessmentQueryService;
import cn.iocoder.yudao.module.hrm.service.performance.assessment.HrmPerformanceAssessmentService;
import cn.iocoder.yudao.module.hrm.service.performance.plan.HrmPerformancePlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertLinkedSet;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - HRM employeeperformance reviewReview.")
@RestController
@RequestMapping("/hrm/performance/assessment")
@Validated
public class HrmPerformanceAssessmentController {

    @Resource
    private HrmPerformanceAssessmentService performanceAssessmentService;
    @Resource
    private HrmPerformanceAssessmentQueryService performanceAssessmentQueryService;
    @Resource
    private HrmPerformancePlanService performancePlanService;
    @Resource
    private HrmEmployeeService employeeService;

    @PostMapping("/create-list")
    @Operation(summary = "Add employeeperformance reviewReview.")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:update')")
    public CommonResult<Boolean> addPerformancePlanEmployees(
            @Valid @RequestBody HrmPerformanceAssessmentBatchReqVO reqVO) {
        performancePlanService.addPerformancePlanEmployees(reqVO);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Operation(summary = "Remove employee performance review.")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:update')")
    public CommonResult<Boolean> removePerformancePlanEmployees(
            @Valid @RequestBody HrmPerformanceAssessmentBatchReqVO reqVO) {
        performancePlanService.removePerformancePlanEmployees(reqVO);
        return success(true);
    }

    @GetMapping("/page")
    @Operation(summary = "Get employeeperformance reviewReview page.")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:query')")
    public CommonResult<PageResult<HrmPerformanceAssessmentRespVO>> getPerformanceAssessmentPage(
            @Validated HrmPerformanceAssessmentPageReqVO reqVO) {
        PageResult<HrmPerformanceAssessmentDO> pageResult =
                performanceAssessmentService.getPerformanceAssessmentPage(reqVO);
        return success(performanceAssessmentQueryService.getPerformanceAssessmentRespVOPage(pageResult));
    }

    @GetMapping("/unassigned-employee-id-list")
    @Operation(summary = "Get not in the specified performance plan employee IDs.")
    @Parameter(name = "planId", description = "Performance reviewplan code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:query')")
    public CommonResult<List<Long>> getPerformancePlanUnassignedEmployeeIdList(
            @RequestParam("planId") Long planId) {
        performancePlanService.validatePerformancePlanExists(planId);
        // 1. 查询已经参与计划的员工
        List<HrmPerformanceAssessmentDO> assessments =
                performanceAssessmentService.getPerformanceAssessmentListByPlanId(planId);
        Set<Long> assignedEmployeeIds = convertSet(assessments, HrmPerformanceAssessmentDO::getEmployeeId);
        // 2. 筛选尚未参与计划的员工
        List<HrmEmployeeDO> employees = employeeService.getEmployeeList(new HrmEmployeeListReqVO());
        return success(convertList(employees, HrmEmployeeDO::getId,
                employee -> !assignedEmployeeIds.contains(employee.getId())));
    }

    @GetMapping("/get")
    @Operation(summary = "Get employeeperformance reviewReview.")
    @Parameter(name = "id", description = "Employeeperformance reviewReview code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:query')")
    public CommonResult<HrmPerformanceAssessmentRespVO> getPerformanceAssessment(@RequestParam("id") Long id) {
        HrmPerformanceAssessmentDO assessment = performanceAssessmentService.getPerformanceAssessment(id);
        return success(performanceAssessmentQueryService.getPerformanceAssessmentProcessRespVO(
                assessment, getLoginUserId()));
    }

    @GetMapping("/process-record-list")
    @Operation(summary = "Get performance reviewworkflowrecord list.")
    @Parameter(name = "id", description = "Employeeperformance reviewReview code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:query')")
    public CommonResult<List<HrmPerformanceProcessRecordRespVO>> getPerformanceAssessmentProcessRecordList(
            @RequestParam("id") Long id) {
        HrmPerformanceAssessmentDO assessment = performanceAssessmentService.getPerformanceAssessment(id);
        return success(performanceAssessmentQueryService.getPerformanceAssessmentProcessRecordList(assessment));
    }

    @GetMapping("/archive-page")
    @Operation(summary = "Get performance archive page.")
    @PreAuthorize("@ss.hasPermission('hrm:performance:archive:query')")
    public CommonResult<PageResult<HrmPerformanceAssessmentRespVO>> getPerformanceAssessmentArchivePage(
            @Validated HrmPerformanceArchivePageReqVO reqVO) {
        PageResult<HrmPerformanceAssessmentDO> pageResult =
                performanceAssessmentService.getPerformanceAssessmentArchivePage(reqVO);
        return success(performanceAssessmentQueryService.getPerformanceAssessmentRespVOPage(pageResult));
    }

    @GetMapping("/archive-employee-page")
    @Operation(summary = "Get employeeperformance review profile page.")
    @PreAuthorize("@ss.hasPermission('hrm:performance:archive:query')")
    public CommonResult<PageResult<HrmPerformanceArchiveEmployeeRespVO>> getPerformanceArchiveEmployeePage(
            @Validated HrmPerformanceArchiveEmployeePageReqVO reqVO) {
        PageResult<HrmEmployeeDO> pageResult =
                performanceAssessmentService.getPerformanceArchiveEmployeePage(reqVO);
        return success(performanceAssessmentQueryService.getPerformanceArchiveEmployeeRespVOPage(pageResult));
    }

    @GetMapping("/archive-get")
    @Operation(summary = "Get performance archive detail.")
    @Parameter(name = "id", description = "Employeeperformance reviewReview code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:performance:archive:query')")
    public CommonResult<HrmPerformanceAssessmentRespVO> getPerformanceAssessmentArchive(@RequestParam("id") Long id) {
        HrmPerformanceAssessmentDO assessment = performanceAssessmentService.getPerformanceAssessmentArchive(id);
        return success(performanceAssessmentQueryService.getPerformanceAssessmentRespVO(assessment));
    }

    @GetMapping("/archive-process-record-list")
    @Operation(summary = "Get performance archive flow records list.")
    @Parameter(name = "id", description = "Employeeperformance reviewReview code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:performance:archive:query')")
    public CommonResult<List<HrmPerformanceProcessRecordRespVO>> getPerformanceAssessmentArchiveProcessRecordList(
            @RequestParam("id") Long id) {
        HrmPerformanceAssessmentDO assessment = performanceAssessmentService.getPerformanceAssessmentArchive(id);
        return success(performanceAssessmentQueryService.getPerformanceAssessmentProcessRecordList(assessment));
    }

    @GetMapping("/archive-plan-simple-list")
    @Operation(summary = "Get performance archive simple plan list.")
    @PreAuthorize("@ss.hasPermission('hrm:performance:archive:query')")
    public CommonResult<List<HrmPerformancePlanRespVO>> getPerformanceArchivePlanSimpleList() {
        // 1. 查询存在归档考核的绩效计划
        List<HrmPerformanceAssessmentDO> assessments =
                performanceAssessmentService.getPerformanceAssessmentListByStatus(
                        HrmPerformancePlanStatusEnum.ARCHIVED.getStatus());
        Set<Long> planIds = convertLinkedSet(assessments, HrmPerformanceAssessmentDO::getPlanId);
        List<HrmPerformancePlanDO> plans = performancePlanService.getPerformancePlanList(planIds);
        // 2. 转换响应
        return success(convertList(plans, plan -> new HrmPerformancePlanRespVO()
                .setId(plan.getId()).setName(plan.getName())));
    }

    @DeleteMapping("/archive-delete")
    @Operation(summary = "Delete performance archive record.")
    @Parameter(name = "ids", description = "Archived review record IDs.", required = true, example = "1024,1025")
    @PreAuthorize("@ss.hasPermission('hrm:performance:archive:delete')")
    public CommonResult<Boolean> deletePerformanceArchiveRecords(
            @RequestParam("ids") @NotEmpty(message = "Archive record cannot be empty.") List<Long> ids) {
        performanceAssessmentService.deletePerformanceArchiveRecords(ids);
        return success(true);
    }

    @DeleteMapping("/archive-employee-delete")
    @Operation(summary = "Deleteemployee Allperformance review profile.")
    @Parameter(name = "employeeIds", description = "Employee code list.", required = true, example = "1024,1025")
    @PreAuthorize("@ss.hasPermission('hrm:performance:archive:delete')")
    public CommonResult<Boolean> deletePerformanceArchiveEmployeeRecords(
            @RequestParam("employeeIds") @NotEmpty(message = "Employee is required.") List<Long> employeeIds) {
        performanceAssessmentService.deletePerformanceArchiveRecordsByEmployeeIds(employeeIds);
        return success(true);
    }

}
