package cn.iocoder.yudao.module.im.controller.admin.message;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.im.controller.admin.message.vo.privates.ImPrivateMessageListReqVO;
import cn.iocoder.yudao.module.im.controller.admin.message.vo.privates.ImPrivateMessageRespVO;
import cn.iocoder.yudao.module.im.controller.admin.message.vo.privates.ImPrivateMessageSendReqVO;
import cn.iocoder.yudao.module.im.dal.dataobject.message.ImPrivateMessageDO;
import cn.iocoder.yudao.module.im.service.message.ImPrivateMessageService;
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

@Tag(name = "Admin - IM direct message.")
@RestController
@RequestMapping("/im/message/private")
@Validated
public class ImPrivateMessageController {

    @Resource
    private ImPrivateMessageService privateMessageService;

    @PostMapping("/send")
    @Operation(summary = "Send direct message.")
    public CommonResult<ImPrivateMessageRespVO> sendPrivateMessage(
            @Valid @RequestBody ImPrivateMessageSendReqVO reqVO) {
        ImPrivateMessageDO message = privateMessageService.sendPrivateMessage(getLoginUserId(), reqVO);
        return success(BeanUtils.toBean(message, ImPrivateMessageRespVO.class));
    }

    @GetMapping("/pull")
    @Operation(summary = "Fetch direct messages incrementally.")
    @Parameter(name = "minId", description = "Minimummessage id.", required = true, example = "0")
    @Parameter(name = "size", description = "Fetch count.", required = true, example = "100")
    public CommonResult<List<ImPrivateMessageRespVO>> pullPrivateMessageList(
            @RequestParam("minId") Long minId,
            @RequestParam("size") @Min(value = 1, message = "Fetch count minimum is 1.") Integer size) {
        List<ImPrivateMessageDO> messages = privateMessageService.pullPrivateMessageList(getLoginUserId(), minId, size);
        return success(BeanUtils.toBean(messages, ImPrivateMessageRespVO.class));
    }

    @PutMapping("/read")
    @Operation(summary = "Markdirect messageRead.")
    @Parameter(name = "receiverId", description = "Recipient user ID (Other Party).", required = true, example = "2")
    @Parameter(name = "messageId", description = "Read position (inclusive), usually the latest message ID in the conversation.", required = true, example = "100")
    public CommonResult<Boolean> readPrivateMessages(@RequestParam("receiverId") Long receiverId,
                                                     @RequestParam("messageId") Long messageId) {
        privateMessageService.readPrivateMessages(getLoginUserId(), receiverId, messageId);
        return success(true);
    }

    @GetMapping("/max-read-message-id")
    @Operation(summary = "Get the farthest message ID the peer has read.",
            description = "Backfill the read position for multi-device or offline use. Call after opening a conversation or reconnecting, then mark locally sent messages read.")
    @Parameter(name = "peerId", description = "The other party user ID.", required = true, example = "2")
    public CommonResult<Long> getMaxReadMessageId(@RequestParam("peerId") Long peerId) {
        return success(privateMessageService.getMaxReadMessageId(getLoginUserId(), peerId));
    }

    @DeleteMapping("/recall")
    @Operation(summary = "Withdraw direct message.")
    @Parameter(name = "id", description = "Message code.", required = true, example = "1")
    public CommonResult<ImPrivateMessageRespVO> recallPrivateMessage(@RequestParam("id") Long id) {
        ImPrivateMessageDO message = privateMessageService.recallPrivateMessage(getLoginUserId(), id);
        return success(BeanUtils.toBean(message, ImPrivateMessageRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "Get direct message history.")
    public CommonResult<List<ImPrivateMessageRespVO>> getPrivateMessageList(@Valid ImPrivateMessageListReqVO reqVO) {
        List<ImPrivateMessageDO> messages = privateMessageService.getPrivateMessageList(getLoginUserId(), reqVO);
        return success(BeanUtils.toBean(messages, ImPrivateMessageRespVO.class));
    }

}
