package cn.iocoder.yudao.module.pms.controller.admin.pm.project;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.group.PmsProjectGroupMoveReqVO;
import cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.group.PmsProjectGroupRespVO;
import cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.group.PmsProjectGroupSaveReqVO;
import cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.group.PmsProjectGroupSortReqVO;
import cn.iocoder.yudao.module.pms.dal.dataobject.pm.project.PmsProjectGroupDO;
import cn.iocoder.yudao.module.pms.service.pm.project.PmsProjectGroupService;
import cn.iocoder.yudao.module.pms.service.pm.project.PmsProjectMemberService;
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

import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - PMS item group.")
@RestController
@RequestMapping("/pms/pm/project-group")
@Validated
public class PmsProjectGroupController {

    @Resource
    private PmsProjectGroupService projectGroupService;
    @Resource
    private PmsProjectMemberService projectMemberService;

    @PostMapping("/create")
    @Operation(summary = "Create item group.")
    @PreAuthorize("@ss.hasPermission('pms:pm:project-group:create')")
    public CommonResult<Long> createProjectGroup(@Valid @RequestBody PmsProjectGroupSaveReqVO createReqVO) {
        return success(projectGroupService.createProjectGroup(createReqVO, getLoginUserId()));
    }

    @PutMapping("/update")
    @Operation(summary = "Edit item group.")
    @PreAuthorize("@ss.hasPermission('pms:pm:project-group:update')")
    public CommonResult<Boolean> updateProjectGroup(@Valid @RequestBody PmsProjectGroupSaveReqVO updateReqVO) {
        projectGroupService.updateProjectGroup(updateReqVO, getLoginUserId());
        return success(true);
    }

    @PutMapping("/update-sort")
    @Operation(summary = "Edit item group sort.")
    @PreAuthorize("@ss.hasPermission('pms:pm:project-group:update')")
    public CommonResult<Boolean> updateProjectGroupSort(@Valid @RequestBody PmsProjectGroupSortReqVO sortReqVO) {
        projectGroupService.updateProjectGroupSort(sortReqVO, getLoginUserId());
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete item group.")
    @Parameter(name = "id", description = "Item group code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pms:pm:project-group:delete')")
    public CommonResult<Boolean> deleteProjectGroup(@RequestParam("id") Long id) {
        projectGroupService.deleteProjectGroup(id, getLoginUserId());
        return success(true);
    }

    @GetMapping("/list")
    @Operation(summary = "Get item group list.")
    @PreAuthorize("@ss.hasPermission('pms:pm:project-group:query')")
    public CommonResult<List<PmsProjectGroupRespVO>> getProjectGroupList() {
        Long userId = getLoginUserId();
        List<PmsProjectGroupDO> groups = projectGroupService.getProjectGroupList(userId);
        List<Long> projectIds = projectMemberService.getActiveProjectIdListByUserId(userId);
        Map<Long, Integer> groupCountMap = projectGroupService.getProjectGroupCountMap(userId, groups, projectIds);
        return success(BeanUtils.toBean(groups, PmsProjectGroupRespVO.class,
                group -> group.setProjectCount(groupCountMap.getOrDefault(group.getId(), 0))));
    }

    @PutMapping("/move-project")
    @Operation(summary = "Move item to person group.")
    @PreAuthorize("@ss.hasPermission('pms:pm:project-group:update')")
    public CommonResult<Boolean> moveProjectToGroup(@Valid @RequestBody PmsProjectGroupMoveReqVO moveReqVO) {
        projectGroupService.moveProjectToGroup(moveReqVO, getLoginUserId());
        return success(true);
    }

}
