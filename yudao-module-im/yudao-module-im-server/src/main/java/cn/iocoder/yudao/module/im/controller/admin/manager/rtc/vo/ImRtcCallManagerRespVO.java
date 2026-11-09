package cn.iocoder.yudao.module.im.controller.admin.manager.rtc.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - IM 通话记录 Response VO")
@Data
public class ImRtcCallManagerRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "业务通话编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "uuid-xxx")
    private String room;

    @Schema(description = "会话类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer conversationType; // See ImConversationTypeEnum enum class

    @Schema(description = "媒体类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer mediaType; // See ImRtcCallMediaTypeEnum enum class

    @Schema(description = "发起人用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long inviterUserId;

    @Schema(description = "发起人昵称", example = "John.")
    private String inviterNickname;

    @Schema(description = "群编号；私聊为空", example = "999")
    private Long groupId;

    @Schema(description = "群名称；私聊为空", example = "Test group")
    private String groupName;

    @Schema(description = "通话状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer status; // See ImRtcCallStatusEnum enum class

    @Schema(description = "结束原因", example = "1")
    private Integer endReason; // See ImRtcCallEndReasonEnum enum class

    @Schema(description = "发起时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime startTime;

    @Schema(description = "接通时间；未接通为空")
    private LocalDateTime acceptTime;

    @Schema(description = "结束时间；未结束为空")
    private LocalDateTime endTime;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
