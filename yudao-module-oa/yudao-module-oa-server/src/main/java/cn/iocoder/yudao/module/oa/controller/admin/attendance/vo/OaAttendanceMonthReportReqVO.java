package cn.iocoder.yudao.module.oa.controller.admin.attendance.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "OA attendance monthly report request VO.")
@Data
public class OaAttendanceMonthReportReqVO {

    @Schema(description = "Year.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026")
    @NotNull(message = "Year is required.")
    @Min(value = 2000, message = "Year cannot be less than 2000.")
    private Integer year;

    @Schema(description = "Month", requiredMode = Schema.RequiredMode.REQUIRED, example = "9")
    @NotNull(message = "Month is required.")
    @Min(value = 1, message = "Month cannot be less than 1.")
    @Max(value = 12, message = "Month cannot be greater than 12.")
    private Integer month;

    @Schema(description = "User ID.", example = "1")
    private Long userId;

}
