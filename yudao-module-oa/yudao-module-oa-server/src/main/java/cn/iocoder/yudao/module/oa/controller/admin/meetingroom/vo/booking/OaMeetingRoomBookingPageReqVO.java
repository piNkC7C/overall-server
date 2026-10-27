package cn.iocoder.yudao.module.oa.controller.admin.meetingroom.vo.booking;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - Meeting roombookingpage request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaMeetingRoomBookingPageReqVO extends PageParam {

    @Schema(description = "Document code.", example = "HY20260914000001")
    private String no;

    @Schema(description = "Room Name", example = "Room 101")
    private String roomName;

    @Schema(description = "Meeting Subject", example = "Product-requirement review")
    private String title;

    @Schema(description = "HostName.", example = "Overall.")
    private String moderatorName;

    @Schema(description = "Apply please department code.", example = "100")
    private Long deptId;

    @Schema(description = "Approval status.", example = "2")
    private Integer status;

    @Schema(description = "Used status.", example = "0")
    private Integer useStatus;

    @Schema(description = "Meeting Start", example = "[\"2026-09-14 00:00:00\",\"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] startTime;

    @Schema(description = "Meeting End")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] endTime;

    @Schema(description = "Creator code.", example = "1")
    private String creator;

    @Schema(description = "Create time.", example = "[\"2026-09-14 00:00:00\",\"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
