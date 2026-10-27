package cn.iocoder.yudao.module.im.controller.admin.message;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.im.controller.admin.message.vo.group.ImGroupMessageListReqVO;
import cn.iocoder.yudao.module.im.controller.admin.message.vo.group.ImGroupMessageRespVO;
import cn.iocoder.yudao.module.im.controller.admin.message.vo.group.ImGroupMessageSendReqVO;
import cn.iocoder.yudao.module.im.dal.dataobject.message.ImGroupMessageDO;
import cn.iocoder.yudao.module.im.service.message.ImGroupMessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - IM group chat message.")
@RestController
@RequestMapping("/im/message/group")
@Validated
public class ImGroupMessageController {

    @Resource
    private ImGroupMessageService groupMessageService;

    @PostMapping("/send")
    @Operation(summary = "Send group chat message.")
    public CommonResult<ImGroupMessageRespVO> sendGroupMessage(@Valid @RequestBody ImGroupMessageSendReqVO reqVO) {
        ImGroupMessageDO message = groupMessageService.sendGroupMessage(getLoginUserId(), reqVO);
        return success(BeanUtils.toBean(message, ImGroupMessageRespVO.class));
    }

    @GetMapping("/pull")
    @Operation(summary = "Fetch group messages incrementally.")
    @Parameter(name = "minId", description = "Minimummessage id.", required = true, example = "0")
    @Parameter(name = "size", description = "Fetch count.", required = true, example = "100")
    public CommonResult<List<ImGroupMessageRespVO>> pullGroupMessageList(
            @RequestParam("minId") Long minId,
            @RequestParam("size") @Min(value = 1, message = "Fetch count minimum is 1.") Integer size) {
        List<ImGroupMessageDO> messages = groupMessageService.pullGroupMessageList(getLoginUserId(), minId, size);
        return success(BeanUtils.toBean(messages, ImGroupMessageRespVO.class));
    }

    @PutMapping("/read")
    @Operation(summary = "Mark group chat message read.")
    @Parameter(name = "groupId", description = "Group ID", required = true, example = "1")
    @Parameter(name = "messageId", description = "Read to message code.", required = true, example = "100")
    public CommonResult<Boolean> readGroupMessages(@RequestParam("groupId") Long groupId,
                                                   @RequestParam("messageId") Long messageId) {
        groupMessageService.readGroupMessages(getLoginUserId(), groupId, messageId);
        return success(true);
    }

    @DeleteMapping("/recall")
    @Operation(summary = "Withdraw group chat message.")
    @Parameter(name = "id", description = "Message code.", required = true, example = "1")
    public CommonResult<ImGroupMessageRespVO> recallGroupMessage(@RequestParam("id") Long id) {
        ImGroupMessageDO message = groupMessageService.recallGroupMessage(getLoginUserId(), id);
        return success(BeanUtils.toBean(message, ImGroupMessageRespVO.class));
    }

    @GetMapping("/get-read-user-ids")
    @Operation(summary = "Get group message read-by user list.")
    @Parameter(name = "groupId", description = "Group ID", required = true, example = "1")
    @Parameter(name = "messageId", description = "Message code.", required = true, example = "1")
    public CommonResult<List<Long>> getGroupReadUserIds(@RequestParam("groupId") Long groupId,
                                                        @RequestParam("messageId") Long messageId) {
        return success(groupMessageService.getGroupReadUserIds(getLoginUserId(), groupId, messageId));
    }

    @GetMapping("/list")
    @Operation(summary = "Search group chat history message.")
    public CommonResult<List<ImGroupMessageRespVO>> getGroupMessageList(@Valid ImGroupMessageListReqVO reqVO) {
        List<ImGroupMessageDO> messages = groupMessageService.getGroupMessageList(getLoginUserId(), reqVO);
        return success(BeanUtils.toBean(messages, ImGroupMessageRespVO.class));
    }

}
