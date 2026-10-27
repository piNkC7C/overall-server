package cn.iocoder.yudao.module.hrm.controller.admin.performance;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment.HrmPerformancePlanResultLevelCountRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment.HrmPerformancePlanStageCountRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.plan.HrmPerformancePlanPageReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.plan.HrmPerformancePlanRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.plan.HrmPerformancePlanSaveReqVO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.performance.assessment.HrmPerformanceAssessmentDO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.performance.assessment.HrmPerformanceAssessmentStageDO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.performance.plan.HrmPerformancePlanDO;
import cn.iocoder.yudao.module.hrm.enums.performance.assessment.HrmPerformanceAssessmentProcessStatusEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.plan.HrmPerformancePlanScopeTypeEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.plan.HrmPerformanceStageTypeEnum;
import cn.iocoder.yudao.module.hrm.service.performance.assessment.HrmPerformanceAssessmentService;
import cn.iocoder.yudao.module.hrm.service.performance.plan.HrmPerformancePlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertListByFlatMap;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertMap;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertMultiMap;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.filterList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.getSumValue;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - HRM performance reviewplan.")
@RestController
@RequestMapping("/hrm/performance/plan")
@Validated
public class HrmPerformancePlanController {

    @Resource
    private HrmPerformancePlanService performancePlanService;
    @Resource
    private HrmPerformanceAssessmentService performanceAssessmentService;

    @PostMapping("/create")
    @Operation(summary = "Createperformance reviewplan.")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:create')")
    public CommonResult<Long> createPerformancePlan(
            @Valid @RequestBody HrmPerformancePlanSaveReqVO reqVO) {
        return success(performancePlanService.createPerformancePlan(reqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updateperformance reviewplan.")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:update')")
    public CommonResult<Boolean> updatePerformancePlan(@Valid @RequestBody HrmPerformancePlanSaveReqVO reqVO) {
        performancePlanService.updatePerformancePlan(reqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteperformance reviewplan.")
    @Parameter(name = "id", description = "Plan code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:delete')")
    public CommonResult<Boolean> deletePerformancePlan(@RequestParam("id") Long id) {
        performancePlanService.deletePerformancePlan(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get performance reviewplan.")
    @Parameter(name = "id", description = "Performance reviewplan code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:query')")
    public CommonResult<HrmPerformancePlanRespVO> getPerformancePlan(@RequestParam("id") Long id) {
        return success(buildPlanRespVO(performancePlanService.getPerformancePlan(id)));
    }

    @GetMapping("/page")
    @Operation(summary = "Get performance reviewplan page.")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:query')")
    public CommonResult<PageResult<HrmPerformancePlanRespVO>> getPerformancePlanPage(
            @Validated HrmPerformancePlanPageReqVO reqVO) {
        PageResult<HrmPerformancePlanDO> pageResult = performancePlanService.getPerformancePlanPage(reqVO);
        return success(new PageResult<>(buildPlanRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @PostMapping("/start")
    @Operation(summary = "Start performance plan.")
    @Parameter(name = "id", description = "Performance reviewplan code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:update')")
    public CommonResult<Boolean> startPerformancePlan(@RequestParam("id") Long id) {
        performancePlanService.startPerformancePlan(id);
        return success(true);
    }

    @PostMapping("/open-scoring")
    @Operation(summary = "Enable performance reviewScore.")
    @Parameter(name = "id", description = "Performance reviewplan code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:update')")
    public CommonResult<Boolean> openPerformancePlanScoring(@RequestParam("id") Long id) {
        performancePlanService.openPerformancePlanScoring(id);
        return success(true);
    }

    @PostMapping("/start-interview")
    @Operation(summary = "Start performance meeting.")
    @Parameter(name = "id", description = "Performance reviewplan code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:update')")
    public CommonResult<Boolean> startPerformancePlanInterview(@RequestParam("id") Long id) {
        performancePlanService.startPerformancePlanInterview(id);
        return success(true);
    }

    @PostMapping("/archive")
    @Operation(summary = "Archive performance plan.")
    @Parameter(name = "id", description = "Performance reviewplan code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:update')")
    public CommonResult<Boolean> archivePerformancePlan(@RequestParam("id") Long id) {
        performancePlanService.archivePerformancePlan(id);
        return success(true);
    }

    @PostMapping("/terminate")
    @Operation(summary = "Terminate performance plan.")
    @Parameter(name = "id", description = "Performance reviewplan code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:update')")
    public CommonResult<Boolean> terminatePerformancePlan(@RequestParam("id") Long id) {
        performancePlanService.terminatePerformancePlan(getLoginUserId(), id);
        return success(true);
    }

    @GetMapping("/status-count")
    @Operation(summary = "Get performance reviewplan statusStats.")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:query')")
    public CommonResult<Map<Integer, Long>> getPerformancePlanStatusCount(
            @Validated HrmPerformancePlanPageReqVO reqVO) {
        return success(performancePlanService.getPerformancePlanStatusCount(reqVO));
    }

    @GetMapping("/stage-count")
    @Operation(summary = "Get performance plan StageStats.")
    @Parameter(name = "planId", description = "Performance reviewplan code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:query')")
    public CommonResult<List<HrmPerformancePlanStageCountRespVO>> getPerformancePlanStageCount(
            @RequestParam("planId") Long planId) {
        performancePlanService.validatePerformancePlanExists(planId);
        // 1.1 search performance plan employeeReview
        List<HrmPerformanceAssessmentDO> assessments =
                performanceAssessmentService.getPerformanceAssessmentListByPlanId(planId);
        // 1.2 按考核阶段统计
        Map<Integer, Long> countMap = convertMap(
                filterList(assessments, assessment -> assessment.getStageType() != null),
                HrmPerformanceAssessmentDO::getStageType, assessment -> 1L, Long::sum, LinkedHashMap::new);
        // 2. 转换响应
        return success(convertList(Arrays.asList(HrmPerformanceStageTypeEnum.ARRAYS),
                stageType -> new HrmPerformancePlanStageCountRespVO()
                        .setStageType(stageType).setCount(countMap.get(stageType)),
                stageType -> countMap.getOrDefault(stageType, 0L) > 0));
    }

    @GetMapping("/level-count")
    @Operation(summary = "Get performance review result level Stats.")
    @Parameter(name = "planId", description = "Performance reviewplan code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:performance:plan:query')")
    public CommonResult<List<HrmPerformancePlanResultLevelCountRespVO>> getPerformancePlanLevelCount(
            @RequestParam("planId") Long planId) {
        HrmPerformancePlanDO plan = performancePlanService.getPerformancePlan(planId);
        if (plan == null) {
            return success(Collections.emptyList());
        }
        // 1.1 search performance plan employeeReview
        List<HrmPerformanceAssessmentDO> assessments =
                performanceAssessmentService.getPerformanceAssessmentListByPlanId(planId);
        // 1.2 按结果模板顺序初始化全部等级，再累计实际人数
        Map<String, Long> levelCountMap = new LinkedHashMap<>();
        plan.getResultConfig().getLevels().forEach(level -> levelCountMap.put(level.getName(), 0L));
        filterList(assessments, assessment -> StrUtil.isNotBlank(assessment.getResultLevel()))
                .forEach(assessment -> levelCountMap.merge(assessment.getResultLevel(), 1L, Long::sum));
        // 2. 转换响应
        return success(convertList(levelCountMap.entrySet(), entry -> new HrmPerformancePlanResultLevelCountRespVO()
                .setLevelName(entry.getKey()).setCount(entry.getValue())));
    }

    // ==================== 拼接 VO ====================

    private HrmPerformancePlanRespVO buildPlanRespVO(HrmPerformancePlanDO plan) {
        return plan == null ? null : CollUtil.getFirst(buildPlanRespVOList(Collections.singletonList(plan)));
    }

    private List<HrmPerformancePlanRespVO> buildPlanRespVOList(List<HrmPerformancePlanDO> plans) {
        // 1. get employeeReview and Stage info
        List<HrmPerformanceAssessmentDO> assessments =
                performanceAssessmentService.getPerformanceAssessmentListByPlanIds(
                        convertList(plans, HrmPerformancePlanDO::getId));
        Map<Long, List<HrmPerformanceAssessmentDO>> assessmentMap =
                convertMultiMap(assessments, HrmPerformanceAssessmentDO::getPlanId);
        List<HrmPerformanceAssessmentStageDO> stages = performanceAssessmentService.getPerformanceAssessmentStageList(
                convertSet(assessments, HrmPerformanceAssessmentDO::getId));
        Map<Long, List<HrmPerformanceAssessmentStageDO>> stageMap =
                convertMultiMap(stages, HrmPerformanceAssessmentStageDO::getAssessmentId);
        // 2. 拼接响应
        Map<Long, HrmPerformancePlanDO> planMap = convertMap(plans, HrmPerformancePlanDO::getId);
        return BeanUtils.toBean(plans, HrmPerformancePlanRespVO.class, respVO -> {
            HrmPerformancePlanDO plan = planMap.get(respVO.getId());
            // 排除员工范围只用于计划内部维护，不返回给前端编辑
            respVO.setScopes(filterList(respVO.getScopes(), scope -> ObjUtil.notEqual(scope.getType(),
                    HrmPerformancePlanScopeTypeEnum.EXCLUDED_EMPLOYEE.getType())));
            if (plan.getAssessmentConfig() != null) {
                respVO.setAssessmentTemplateName(plan.getAssessmentConfig().getName());
            }
            if (plan.getResultConfig() != null) {
                respVO.setResultTemplateName(plan.getResultConfig().getName());
            }
            // 获得当前计划的员工考核和处理阶段，用于统计执行进度并判断后续可操作节点
            List<HrmPerformanceAssessmentDO> planAssessments =
                    assessmentMap.getOrDefault(plan.getId(), Collections.emptyList());
            List<HrmPerformanceAssessmentStageDO> planStages = convertListByFlatMap(
                    planAssessments, assessment -> stageMap.getOrDefault(
                            assessment.getId(), Collections.emptyList()).stream());
            int finishedCount = getSumValue(planAssessments, assessment -> Objects.equals(
                    assessment.getProcessStatus(),
                    HrmPerformanceAssessmentProcessStatusEnum.FINISHED.getStatus()) ? 1 : 0, Integer::sum, 0);
            Map<Integer, Long> stageCountMap = convertMap(
                    filterList(planAssessments, assessment -> assessment.getStageType() != null),
                    HrmPerformanceAssessmentDO::getStageType, assessment -> 1L, Long::sum, LinkedHashMap::new);
            respVO.setEmployeeCount(planAssessments.size()).setFinishedCount(finishedCount)
                    .setStageCountMap(stageCountMap)
                    .setScoringReady(performanceAssessmentService
                            .isPerformanceAssessmentScoringReady(plan, planAssessments))
                    .setInterviewReady(performanceAssessmentService
                            .isPerformanceAssessmentInterviewReady(plan, planAssessments, planStages))
                    .setArchiveReady(performanceAssessmentService
                            .isPerformanceAssessmentArchiveReady(plan, planAssessments));
        });
    }

}
