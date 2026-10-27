package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.label.PmsWorkItemLabelRespVO;
import cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.status.PmsWorkItemStatusUpdateReqVO;
import cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem.PmsWorkItemBoardReqVO;
import cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem.PmsWorkItemBoardRespVO;
import cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem.PmsWorkItemImportExcelVO;
import cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem.PmsWorkItemImportRespVO;
import cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem.PmsWorkItemIterationUpdateReqVO;
import cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem.PmsWorkItemNameUpdateReqVO;
import cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem.PmsWorkItemPageReqVO;
import cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem.PmsWorkItemPlanningSortReqVO;
import cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem.PmsWorkItemRespVO;
import cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem.PmsWorkItemSaveReqVO;
import cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem.PmsWorkItemSortReqVO;
import cn.iocoder.yudao.module.pms.dal.dataobject.pm.iteration.PmsIterationDO;
import cn.iocoder.yudao.module.pms.dal.dataobject.pm.workitem.PmsWorkItemDO;
import cn.iocoder.yudao.module.pms.dal.dataobject.pm.workitem.PmsWorkItemLabelDO;
import cn.iocoder.yudao.module.pms.dal.dataobject.pm.workitem.PmsWorkItemStatusDO;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemPriorityEnum;
import cn.iocoder.yudao.module.pms.service.pm.iteration.PmsIterationService;
import cn.iocoder.yudao.module.pms.service.pm.workitem.PmsWorkItemLabelService;
import cn.iocoder.yudao.module.pms.service.pm.workitem.PmsWorkItemService;
import cn.iocoder.yudao.module.pms.service.pm.workitem.PmsWorkItemStatusService;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertListByFlatMap;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSetByFlatMap;
import static cn.iocoder.yudao.framework.common.util.collection.MapUtils.findAndThen;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - PMS work item.")
@RestController
@RequestMapping("/pms/pm/work-item")
@Validated
public class PmsWorkItemController {

    @Resource
    private PmsWorkItemService workItemService;
    @Resource
    private PmsWorkItemLabelService workItemLabelService;
    @Resource
    private PmsWorkItemStatusService workItemStatusService;
    @Resource
    private PmsIterationService iterationService;

    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "Create work item.")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:create')")
    public CommonResult<Long> createWorkItem(@Valid @RequestBody PmsWorkItemSaveReqVO saveReqVO) {
        return success(workItemService.createWorkItem(saveReqVO, getLoginUserId()));
    }

    @PutMapping("/update")
    @Operation(summary = "Update work item.")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:update')")
    public CommonResult<Boolean> updateWorkItem(@Valid @RequestBody PmsWorkItemSaveReqVO saveReqVO) {
        workItemService.updateWorkItem(saveReqVO, getLoginUserId());
        return success(true);
    }

    @PutMapping("/update-name")
    @Operation(summary = "Update work item name.")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:update')")
    public CommonResult<Boolean> updateWorkItemName(@Valid @RequestBody PmsWorkItemNameUpdateReqVO updateReqVO) {
        workItemService.updateWorkItemName(updateReqVO, getLoginUserId());
        return success(true);
    }

    @PutMapping("/update-status")
    @Operation(summary = "Update work item status.")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:update')")
    public CommonResult<Boolean> updateWorkItemStatus(@Valid @RequestBody PmsWorkItemStatusUpdateReqVO updateReqVO) {
        workItemService.updateWorkItemStatus(updateReqVO, getLoginUserId());
        return success(true);
    }

    @PutMapping("/update-iteration")
    @Operation(summary = "Update work item sprint.")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:update')")
    public CommonResult<Boolean> updateWorkItemIteration(@Valid @RequestBody PmsWorkItemIterationUpdateReqVO updateReqVO) {
        workItemService.updateWorkItemIteration(updateReqVO, getLoginUserId());
        return success(true);
    }

    @PutMapping("/update-sort")
    @Operation(summary = "Update work-item order in a board column.")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:update')")
    public CommonResult<Boolean> updateWorkItemSort(@Valid @RequestBody PmsWorkItemSortReqVO sortReqVO) {
        workItemService.updateWorkItemSort(sortReqVO, getLoginUserId());
        return success(true);
    }

    @PutMapping("/update-planning-sort")
    @Operation(summary = "Update work-item order in backlog or a sprint.")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:update')")
    public CommonResult<Boolean> updateWorkItemPlanningSort(@Valid @RequestBody PmsWorkItemPlanningSortReqVO sortReqVO) {
        workItemService.updateWorkItemPlanningSort(sortReqVO, getLoginUserId());
        return success(true);
    }

    @PutMapping("/archive")
    @Operation(summary = "Archive work item.")
    @Parameter(name = "id", description = "Work item code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:update')")
    public CommonResult<Boolean> archiveWorkItem(@RequestParam("id") Long id) {
        workItemService.archiveWorkItem(id, getLoginUserId());
        return success(true);
    }

    @PutMapping("/recycle")
    @Operation(summary = "Work item Move to trash.")
    @Parameter(name = "id", description = "Work item code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:update')")
    public CommonResult<Boolean> recycleWorkItem(@RequestParam("id") Long id) {
        workItemService.recycleWorkItem(id, getLoginUserId());
        return success(true);
    }

    @PutMapping("/restore")
    @Operation(summary = "Restore work item.")
    @Parameter(name = "id", description = "Work item code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:update')")
    public CommonResult<Boolean> restoreWorkItem(@RequestParam("id") Long id) {
        workItemService.restoreWorkItem(id, getLoginUserId());
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Permanently delete recycle bin work item.")
    @Parameter(name = "id", description = "Work item code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:delete')")
    public CommonResult<Boolean> deleteWorkItem(@RequestParam("id") Long id) {
        workItemService.deleteWorkItem(id, getLoginUserId());
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get work item details.")
    @Parameter(name = "id", description = "Work item code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:query')")
    public CommonResult<PmsWorkItemRespVO> getWorkItem(@RequestParam("id") Long id) {
        PmsWorkItemDO workItem = workItemService.getWorkItem(id, getLoginUserId());
        PmsWorkItemRespVO workItemVO = buildWorkItemRespVO(workItem);
        return success(workItemVO);
    }

    @GetMapping("/page")
    @Operation(summary = "Get work item page.")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:query')")
    public CommonResult<PageResult<PmsWorkItemRespVO>> getWorkItemPage(@Valid PmsWorkItemPageReqVO pageReqVO) {
        PageResult<PmsWorkItemDO> pageResult = workItemService.getWorkItemPage(pageReqVO, getLoginUserId());
        return success(new PageResult<>(buildWorkItemRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export work item.")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:export')")
    public void exportWorkItemList(@Valid PmsWorkItemPageReqVO pageReqVO,
                                    HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<PmsWorkItemDO> list = workItemService.getWorkItemList(pageReqVO, getLoginUserId());
        List<PmsWorkItemRespVO> workItemVOList = buildWorkItemRespVOList(list);
        ExcelUtils.write(response, "Work Items.xlsx", "Work Items", PmsWorkItemRespVO.class, workItemVOList);
    }

    @GetMapping("/get-import-template")
    @Operation(summary = "Download work item import template.")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:import')")
    public void getWorkItemImportTemplate(HttpServletResponse response) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime deadline = now.plusDays(3);
        PmsWorkItemImportExcelVO example = PmsWorkItemImportExcelVO.builder()
                .name("Sign-In Page").description("Implement username and password sign-in").statusName("")
                .priority(PmsWorkItemPriorityEnum.MEDIUM.getPriority())
                .startTime(now).endTime(deadline)
                .labels(Collections.emptyList()).progress(0).estimatedHours(16)
                .build();
        ExcelUtils.write(response, "Work Item Import Template.xlsx", "Work Items", PmsWorkItemImportExcelVO.class,
                Collections.singletonList(example));
    }

    @PostMapping("/import")
    @Operation(summary = "Import work item.")
    @Parameters({
            @Parameter(name = "projectId", description = "Item code.", required = true, example = "1024"),
            @Parameter(name = "type", description = "Work item type ( requirement 、task、 defect ).", required = true, example = "1"),
            @Parameter(name = "file", description = "Excel file.", required = true)
    })
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:import')")
    public CommonResult<PmsWorkItemImportRespVO> importWorkItemList(
            @RequestParam("projectId") Long projectId,
            @RequestParam("type") Integer workItemType,
            @RequestParam("file") MultipartFile file) throws Exception {
        return success(workItemService.importWorkItemList(projectId, workItemType,
                ExcelUtils.read(file, PmsWorkItemImportExcelVO.class), getLoginUserId()));
    }

    @GetMapping("/board")
    @Operation(summary = "Get work item board.")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:query')")
    public CommonResult<List<PmsWorkItemBoardRespVO>> getWorkItemBoard(@Valid PmsWorkItemBoardReqVO queryReqVO) {
        List<PmsWorkItemBoardRespVO> columns = workItemService.getWorkItemBoard(queryReqVO, getLoginUserId());
        fillWorkItemRespVOList(convertListByFlatMap(columns, column -> column.getItems().stream()));
        return success(columns);
    }

    // ==================== 拼接 VO ====================

    private PmsWorkItemRespVO buildWorkItemRespVO(PmsWorkItemDO workItem) {
        return CollUtil.getFirst(buildWorkItemRespVOList(Collections.singletonList(workItem)));
    }

    private List<PmsWorkItemRespVO> buildWorkItemRespVOList(List<PmsWorkItemDO> workItems) {
        if (CollUtil.isEmpty(workItems)) {
            return Collections.emptyList();
        }
        return fillWorkItemRespVOList(BeanUtils.toBean(workItems, PmsWorkItemRespVO.class));
    }

    private List<PmsWorkItemRespVO> fillWorkItemRespVOList(List<PmsWorkItemRespVO> workItems) {
        if (CollUtil.isEmpty(workItems)) {
            return Collections.emptyList();
        }

        // 1.1 批量查询状态、迭代、关联需求和参与人
        Map<Long, PmsWorkItemStatusDO> statusMap = workItemStatusService.getWorkItemStatusMap(
                convertSet(workItems, PmsWorkItemRespVO::getStatusId));
        Map<Long, PmsIterationDO> iterationMap = iterationService.getIterationMap(
                convertSet(workItems, PmsWorkItemRespVO::getIterationId));
        Map<Long, PmsWorkItemDO> requirementMap = workItemService.getWorkItemMap(
                convertSet(workItems, PmsWorkItemRespVO::getRelatedRequirementId));
        Map<Long, List<Long>> memberUserIdListMap = workItemService.getWorkItemMemberUserIdListMap(
                convertSet(workItems, PmsWorkItemRespVO::getId));
        Map<Long, PmsWorkItemLabelDO> labelMap = workItemLabelService.getWorkItemLabelMap(
                convertSetByFlatMap(workItems, PmsWorkItemRespVO::getLabelIds, List::stream));
        // 1.2 批量查询负责人和参与人用户
        Set<Long> userIds = convertSetByFlatMap(workItems, workItem -> java.util.stream.Stream.concat(
                java.util.stream.Stream.of(workItem.getAssigneeUserId()),
                memberUserIdListMap.getOrDefault(workItem.getId(), Collections.emptyList()).stream()));
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(userIds);
        // 2. 拼接工作项展示字段
        for (PmsWorkItemRespVO workItemVO : workItems) {
            findAndThen(statusMap, workItemVO.getStatusId(), status -> workItemVO.setStatusName(status.getName()));
            findAndThen(iterationMap, workItemVO.getIterationId(),
                    iteration -> workItemVO.setIterationName(iteration.getName()));
            findAndThen(requirementMap, workItemVO.getRelatedRequirementId(),
                    requirement -> workItemVO.setRelatedRequirementName(requirement.getName()));
            findAndThen(userMap, workItemVO.getAssigneeUserId(),
                    assignee -> workItemVO.setAssigneeUserName(assignee.getNickname()));
            List<Long> memberUserIds = memberUserIdListMap.getOrDefault(workItemVO.getId(), Collections.emptyList());
            List<String> memberUserNames = convertList(convertList(memberUserIds, userMap::get),
                    AdminUserRespDTO::getNickname);
            workItemVO.setMemberUserIds(memberUserIds).setMemberUserNames(memberUserNames);
            workItemVO.setLabels(BeanUtils.toBean(convertList(workItemVO.getLabelIds(), labelMap::get),
                    PmsWorkItemLabelRespVO.class));
        }
        return workItems;
    }

}
