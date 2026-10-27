package cn.iocoder.yudao.module.oa.controller.admin.meetingroom.vo.booking;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - Meeting roombooking response.")
@Data
public class OaMeetingRoomBookingRespVO {

    @Schema(description = "Code.", example = "1024", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "Meeting-room ID.", example = "1024", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long roomId;

    @Schema(description = "Meeting Subject", example = "Product-requirement review", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @Schema(description = "Meeting Start", example = "1789351200000", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64")
    private LocalDateTime startTime;

    @Schema(description = "Meeting End", example = "1789354800000", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64")
    private LocalDateTime endTime;

    @Schema(description = "Host user ID.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long moderatorUserId;

    @Schema(description = "Attendeesuser IDlist.", example = "[1,2]")
    private List<Long> attendeeUserIds;

    @Schema(description = "Meeting reminder.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer reminderType;

    @Schema(description = "Meeting notes.", example = "Discuss product requirements and schedule")
    private String description;

    @Schema(description = "Apply please notes.", example = "Please book a room in advance")
    private String remark;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://www.iocoder.cn/meeting.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "Apply please order no.", example = "HY20260914000001", requiredMode = Schema.RequiredMode.REQUIRED)
    private String no;

    @Schema(description = "Room Name", example = "Room 101")
    private String roomName;

    @Schema(description = "Location", example = "Building 1, Room 101")
    private String roomLocation;

    @Schema(description = "Room Type", example = "1")
    private Integer roomType;

    @Schema(description = "HostName.", example = "Overall.")
    private String moderatorName;

    @Schema(description = "AttendeesName.", example = "[\"Potato\",\"Sam\"]")
    private List<String> attendeeNames;

    @Schema(description = "Apply please person.", example = "Overall.")
    private String creatorName;

    @Schema(description = "Apply please department code.", example = "100")
    private Long deptId;

    @Schema(description = "Department name.", example = "R&D")
    private String deptName;

    @Schema(description = "Approval status.", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer status;

    @Schema(description = "Used status.", example = "0", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer useStatus;

    @Schema(description = "Submit time is not need to need approval.", example = "false")
    private Boolean needApproval;

    @Schema(description = "Workflow instance code.", example = "process-1024")
    private String processInstanceId;

    @Schema(description = "Create time.", example = "1789347600000", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64")
    private LocalDateTime createTime;

}
