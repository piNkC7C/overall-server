package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.holiday;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.attendance.config.HrmAttendanceHolidayTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - HRM attendance holiday save request.")
@Data
public class HrmAttendanceHolidaySaveReqVO {

    @Schema(description = "Holiday code.", example = "1024")
    private Long id;

    @Schema(description = "Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Date is required.")
    private LocalDateTime date;

    @Schema(description = "Holiday type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Type is required.")
    @InEnum(value = HrmAttendanceHolidayTypeEnum.class, message = "Holiday type must be {value}.")
    private Integer type;

}
