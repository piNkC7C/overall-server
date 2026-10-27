package cn.iocoder.yudao.module.ai.controller.admin.model;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.ai.controller.admin.model.vo.chatRole.AiChatRolePageReqVO;
import cn.iocoder.yudao.module.ai.controller.admin.model.vo.chatRole.AiChatRoleRespVO;
import cn.iocoder.yudao.module.ai.controller.admin.model.vo.chatRole.AiChatRoleSaveMyReqVO;
import cn.iocoder.yudao.module.ai.controller.admin.model.vo.chatRole.AiChatRoleSaveReqVO;
import cn.iocoder.yudao.module.ai.dal.dataobject.model.AiChatRoleDO;
import cn.iocoder.yudao.module.ai.service.model.AiChatRoleService;
import org.dromara.core.trans.anno.TransMethodResult;
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
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - AI chat persona.")
@RestController
@RequestMapping("/ai/chat-role")
@Validated
public class AiChatRoleController {

    @Resource
    private AiChatRoleService chatRoleService;

    @GetMapping("/my-page")
    @Operation(summary = "Get [ my ] chat persona page.")
    @TransMethodResult
    public CommonResult<PageResult<AiChatRoleRespVO>> getChatRoleMyPage(@Valid AiChatRolePageReqVO pageReqVO) {
        PageResult<AiChatRoleDO> pageResult = chatRoleService.getChatRoleMyPage(pageReqVO, getLoginUserId());
        return success(BeanUtils.toBean(pageResult, AiChatRoleRespVO.class));
    }

    @GetMapping("/get-my")
    @Operation(summary = "Get [ my ] chat persona.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @TransMethodResult
    public CommonResult<AiChatRoleRespVO> getChatRoleMy(@RequestParam("id") Long id) {
        AiChatRoleDO chatRole = chatRoleService.getChatRole(id);
        if (ObjUtil.notEqual(chatRole.getUserId(), getLoginUserId())) {
            return success(null);
        }
        return success(BeanUtils.toBean(chatRole, AiChatRoleRespVO.class));
    }

    @PostMapping("/create-my")
    @Operation(summary = "Create [ my ] chat persona.")
    public CommonResult<Long> createChatRoleMy(@Valid @RequestBody AiChatRoleSaveMyReqVO createReqVO) {
        return success(chatRoleService.createChatRoleMy(createReqVO, getLoginUserId()));
    }

    @PutMapping("/update-my")
    @Operation(summary = "Update [ my ] chat persona.")
    public CommonResult<Boolean> updateChatRoleMy(@Valid @RequestBody AiChatRoleSaveMyReqVO updateReqVO) {
        chatRoleService.updateChatRoleMy(updateReqVO, getLoginUserId());
        return success(true);
    }

    @DeleteMapping("/delete-my")
    @Operation(summary = "Delete [ my ] chat persona.")
    @Parameter(name = "id", description = "Code.", required = true)
    public CommonResult<Boolean> deleteChatRoleMy(@RequestParam("id") Long id) {
        chatRoleService.deleteChatRoleMy(id, getLoginUserId());
        return success(true);
    }

    @GetMapping("/category-list")
    @Operation(summary = "Get chat persona categories list.")
    public CommonResult<List<String>> getChatRoleCategoryList() {
        return success(chatRoleService.getChatRoleCategoryList());
    }

    // ========== role admin ==========

    @PostMapping("/create")
    @Operation(summary = "Create chat persona.")
    @PreAuthorize("@ss.hasPermission('ai:chat-role:create')")
    public CommonResult<Long> createChatRole(@Valid @RequestBody AiChatRoleSaveReqVO createReqVO) {
        return success(chatRoleService.createChatRole(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update chat persona.")
    @PreAuthorize("@ss.hasPermission('ai:chat-role:update')")
    public CommonResult<Boolean> updateChatRole(@Valid @RequestBody AiChatRoleSaveReqVO updateReqVO) {
        chatRoleService.updateChatRole(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete chat persona.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('ai:chat-role:delete')")
    public CommonResult<Boolean> deleteChatRole(@RequestParam("id") Long id) {
        chatRoleService.deleteChatRole(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get chat persona.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('ai:chat-role:query')")
    @TransMethodResult
    public CommonResult<AiChatRoleRespVO> getChatRole(@RequestParam("id") Long id) {
        AiChatRoleDO chatRole = chatRoleService.getChatRole(id);
        return success(BeanUtils.toBean(chatRole, AiChatRoleRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get chat persona page.")
    @PreAuthorize("@ss.hasPermission('ai:chat-role:query')")
    public CommonResult<PageResult<AiChatRoleRespVO>> getChatRolePage(@Valid AiChatRolePageReqVO pageReqVO) {
        PageResult<AiChatRoleDO> pageResult = chatRoleService.getChatRolePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AiChatRoleRespVO.class));
    }

}
