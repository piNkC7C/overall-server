package cn.iocoder.yudao.module.oa.controller.admin.meetingroom.vo.booking;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.meetingroom.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - Meeting roombookingcreate/update request.")
@Data
public class OaMeetingRoomBookingSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Meeting-room ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Meeting room cannot be empty.")
    private Long roomId;

    @Schema(description = "Meeting Subject", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product-requirement review")
    @NotBlank(message = "Meeting Subject is required.")
    @Size(max = 200, message = "Meeting Subject length cannot exceed {max} characters.")
    private String title;

    @Schema(description = "Meeting Start", requiredMode = Schema.RequiredMode.REQUIRED, example = "1789351200000", type = "integer", format = "int64")
    @NotNull(message = "Start time is required.")
    private LocalDateTime startTime;

    @Schema(description = "Meeting End", requiredMode = Schema.RequiredMode.REQUIRED, example = "1789354800000", type = "integer", format = "int64")
    @NotNull(message = "End time is required.")
    private LocalDateTime endTime;

    @Schema(description = "Host user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Host is required.")
    private Long moderatorUserId;

    @Schema(description = "Attendeesuser IDlist.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1,2]")
    @NotNull(message = "Attendees cannot be empty.")
    private List<@NotNull(message = "Attendees cannot be empty.") Long> attendeeUserIds;

    @Schema(description = "Meeting reminder.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Meeting reminder cannot be empty.")
    @InEnum(value = OaMeetingRoomReminderTypeEnum.class, message = "Meeting reminder is invalid.")
    private Integer reminderType;

    @Schema(description = "Meeting notes.", example = "Discuss product requirements and schedule")
    @Size(max = 500, message = "Meeting notes cannot exceed {max} characters.")
    private String description;

    @Schema(description = "Apply please notes.", example = "Please book a room in advance")
    @Size(max = 500, message = "Apply please notes length cannot exceed {max} characters.")
    private String remark;

    @Schema(description = "AttachmentAddress list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[\"https://www.iocoder.cn/meeting.pdf\"]")
    @NotNull(message = "AttachmentAddress list is required.")
    private List<@NotBlank(message = "AttachmentAddress list is required.") String> fileUrls;

}
