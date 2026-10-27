package cn.iocoder.yudao.module.bpm.controller.admin.definition;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.group.BpmUserGroupPageReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.group.BpmUserGroupRespVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.group.BpmUserGroupSaveReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.definition.BpmUserGroupDO;
import cn.iocoder.yudao.module.bpm.service.definition.BpmUserGroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "Admin - user group.")
@RestController
@RequestMapping("/bpm/user-group")
@Validated
public class BpmUserGroupController {

    @Resource
    private BpmUserGroupService userGroupService;

    @PostMapping("/create")
    @Operation(summary = "Createuser group.")
    @PreAuthorize("@ss.hasPermission('bpm:user-group:create')")
    public CommonResult<Long> createUserGroup(@Valid @RequestBody BpmUserGroupSaveReqVO createReqVO) {
        return success(userGroupService.createUserGroup(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updateuser group.")
    @PreAuthorize("@ss.hasPermission('bpm:user-group:update')")
    public CommonResult<Boolean> updateUserGroup(@Valid @RequestBody BpmUserGroupSaveReqVO updateReqVO) {
        userGroupService.updateUserGroup(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteuser group.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('bpm:user-group:delete')")
    public CommonResult<Boolean> deleteUserGroup(@RequestParam("id") Long id) {
        userGroupService.deleteUserGroup(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get user group.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bpm:user-group:query')")
    public CommonResult<BpmUserGroupRespVO> getUserGroup(@RequestParam("id") Long id) {
        BpmUserGroupDO userGroup = userGroupService.getUserGroup(id);
        return success(BeanUtils.toBean(userGroup, BpmUserGroupRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get user group page.")
    @PreAuthorize("@ss.hasPermission('bpm:user-group:query')")
    public CommonResult<PageResult<BpmUserGroupRespVO>> getUserGroupPage(@Valid BpmUserGroupPageReqVO pageVO) {
        PageResult<BpmUserGroupDO> pageResult = userGroupService.getUserGroupPage(pageVO);
        return success(BeanUtils.toBean(pageResult, BpmUserGroupRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get user group simple info list.", description = "Only enabled user group. Used for dropdowns.")
    public CommonResult<List<BpmUserGroupRespVO>> getUserGroupSimpleList() {
        List<BpmUserGroupDO> list = userGroupService.getUserGroupListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(convertList(list, group -> new BpmUserGroupRespVO().setId(group.getId()).setName(group.getName())));
    }

}
