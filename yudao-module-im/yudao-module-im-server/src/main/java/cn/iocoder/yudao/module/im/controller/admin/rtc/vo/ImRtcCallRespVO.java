package cn.iocoder.yudao.module.im.controller.admin.rtc.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Schema(description = "管理后台 - 通话会话 Response VO；invite / accept / refreshToken 共用")
@Data
public class ImRtcCallRespVO {

    @Schema(description = "业务通话编号")
    private String room;

    @Schema(description = "LiveKit Server WebSocket 地址；前端 connect 用")
    private String livekitUrl;

    @Schema(description = "LiveKit 接入 Token；需要时调 refreshToken 重新签发")
    private String token;

    @Schema(description = "会话类型")
    private Integer conversationType; // See ImConversationTypeEnum enum class

    @Schema(description = "媒体类型")
    private Integer mediaType; // See ImCallMediaTypeEnum enum class

    @Schema(description = "状态")
    private Integer status; // See ImCallStatusEnum enum class

    @Schema(description = "结束原因；仅 status=ENDED 时有值")
    private Integer endReason; // See ImRtcCallEndReasonEnum enum class

    @Schema(description = "发起人编号")
    private Long inviterId;

    @Schema(description = "群编号；群通话才有")
    private Long groupId;

    @Schema(description = "被邀请人编号集合")
    private Set<Long> inviteeIds;

    @Schema(description = "已加入房间的成员编号集合")
    private Set<Long> joinedUserIds;

}
