package cn.iocoder.yudao.module.oa.controller.admin.meetingroom.vo.booking;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.meetingroom.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - 会议室预定新增/修改 Request VO")
@Data
public class OaMeetingRoomBookingSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "会议室编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Meeting room cannot be empty.")
    private Long roomId;

    @Schema(description = "会议主题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product-requirement review")
    @NotBlank(message = "Meeting Subject is required.")
    @Size(max = 200, message = "Meeting Subject length cannot exceed {max} characters.")
    private String title;

    @Schema(description = "会议开始时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "1789351200000", type = "integer", format = "int64")
    @NotNull(message = "Start time is required.")
    private LocalDateTime startTime;

    @Schema(description = "会议结束时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "1789354800000", type = "integer", format = "int64")
    @NotNull(message = "End time is required.")
    private LocalDateTime endTime;

    @Schema(description = "主持人用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Host is required.")
    private Long moderatorUserId;

    @Schema(description = "参会人用户编号列表", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1,2]")
    @NotNull(message = "Attendees cannot be empty.")
    private List<@NotNull(message = "Attendees cannot be empty.") Long> attendeeUserIds;

    @Schema(description = "会议提醒", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Meeting reminder cannot be empty.")
    @InEnum(value = OaMeetingRoomReminderTypeEnum.class, message = "Meeting reminder is invalid.")
    private Integer reminderType;

    @Schema(description = "会议说明", example = "Discuss product requirements and schedule")
    @Size(max = 500, message = "Meeting notes cannot exceed {max} characters.")
    private String description;

    @Schema(description = "申请备注", example = "Please book a room in advance")
    @Size(max = 500, message = "Apply please notes length cannot exceed {max} characters.")
    private String remark;

    @Schema(description = "附件地址列表", requiredMode = Schema.RequiredMode.REQUIRED, example = "[\"https://www.iocoder.cn/meeting.pdf\"]")
    @NotNull(message = "AttachmentAddress list is required.")
    private List<@NotBlank(message = "AttachmentAddress list is required.") String> fileUrls;

}
