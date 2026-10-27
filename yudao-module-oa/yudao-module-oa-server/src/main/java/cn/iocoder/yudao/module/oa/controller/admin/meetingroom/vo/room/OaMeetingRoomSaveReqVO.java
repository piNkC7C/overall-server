package cn.iocoder.yudao.module.oa.controller.admin.meetingroom.vo.room;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.meetingroom.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - Meeting roomcreate/update request.")
@Data
public class OaMeetingRoomSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Room Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Room 101")
    @NotBlank(message = "Room Name is required.")
    @Size(max = 100, message = "Room Name length cannot exceed {max} characters.")
    private String name;

    @Schema(description = "Location", requiredMode = Schema.RequiredMode.REQUIRED, example = "Building 1, Room 101")
    @NotBlank(message = "Location is required.")
    @Size(max = 255, message = "Location length cannot exceed {max} characters.")
    private String location;

    @Schema(description = "Room Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Type is required.")
    @InEnum(value = OaMeetingRoomTypeEnum.class, message = "Room Type is invalid.")
    private Integer type;

    @Schema(description = "Owner person user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Owner person is required.")
    private Long managerUserId;

    @Schema(description = "Can status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Can status is required.")
    @InEnum(value = OaMeetingRoomStatusEnum.class, message = "Can status is invalid.")
    private Integer status;

    @Schema(description = "Meeting-room image.", example = "https://www.iocoder.cn/meeting-room.jpg")
    @Size(max = 1024, message = "Meeting-room image cannot exceed {max} characters.")
    private String picUrl;

    @Schema(description = "Seats", example = "8")
    @Min(value = 1, message = "Seat count cannot be less than {value}.")
    private Integer seatCount;

    @Schema(description = "Device list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1,2]")
    @NotNull(message = "Device list is required.")
    private List<@NotNull(message = "Device list is required.") Integer> equipments;

    @Schema(description = "Booking allowed.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Booking allowed cannot be empty.")
    private Boolean allowBooking;

    @Schema(description = "Booking requires approval.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Booking requires approval cannot be empty.")
    private Boolean needApproval;

    @Schema(description = "Bookable range.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Bookable range cannot be empty.")
    @InEnum(value = OaMeetingRoomBookingScopeEnum.class, message = "Bookable range is invalid.")
    private Integer bookingScope;

    @Schema(description = "Members who can bookuser IDlist.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1,2]")
    @NotNull(message = "Members who can book cannot be empty.")
    private List<@NotNull(message = "Members who can book cannot be empty.") Long> bookingUserIds;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Notes.", example = "Please book a room in advance")
    @Size(max = 200, message = "Notes length cannot exceed {max} characters.")
    private String remark;

    @Schema(description = "AttachmentAddress list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[\"https://www.iocoder.cn/meeting.pdf\"]")
    @NotNull(message = "AttachmentAddress list is required.")
    private List<@NotBlank(message = "AttachmentAddress list is required.") String> fileUrls;

}
