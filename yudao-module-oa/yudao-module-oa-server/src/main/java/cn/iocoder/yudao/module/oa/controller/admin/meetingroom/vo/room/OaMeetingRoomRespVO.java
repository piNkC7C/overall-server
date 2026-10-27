package cn.iocoder.yudao.module.oa.controller.admin.meetingroom.vo.room;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - Meeting room response.")
@Data
public class OaMeetingRoomRespVO {

    @Schema(description = "Code.", example = "1024", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "Room Name", example = "Room 101", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(description = "Location", example = "Building 1, Room 101", requiredMode = Schema.RequiredMode.REQUIRED)
    private String location;

    @Schema(description = "Room Type", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer type;

    @Schema(description = "Owner person user ID.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long managerUserId;

    @Schema(description = "Can status.", example = "0", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer status;

    @Schema(description = "Meeting-room image.", example = "https://www.iocoder.cn/meeting-room.jpg")
    private String picUrl;

    @Schema(description = "Seats", example = "8")
    private Integer seatCount;

    @Schema(description = "Device list.", example = "[1,2]")
    private List<Integer> equipments;

    @Schema(description = "Booking allowed.", example = "true", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean allowBooking;

    @Schema(description = "Booking requires approval.", example = "false", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean needApproval;

    @Schema(description = "Bookable range.", example = "0", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer bookingScope;

    @Schema(description = "Members who can bookuser IDlist.", example = "[1,2]")
    private List<Long> bookingUserIds;

    @Schema(description = "Sort", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer sort;

    @Schema(description = "Notes.", example = "Please book a room in advance")
    private String remark;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://www.iocoder.cn/meeting.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "Owner person Name.", example = "Overall.")
    private String managerName;

    @Schema(description = "Owner person Contact.", example = "13800138000")
    private String managerPhone;

    @Schema(description = "Create time.", example = "1789347600000", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64")
    private LocalDateTime createTime;

}
