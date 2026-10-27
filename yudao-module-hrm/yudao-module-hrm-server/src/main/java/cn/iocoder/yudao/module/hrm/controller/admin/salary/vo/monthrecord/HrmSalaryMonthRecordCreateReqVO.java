package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.monthrecord;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "HRM monthly payroll sheet create request VO.")
@Data
public class HrmSalaryMonthRecordCreateReqVO {

    @Schema(description = "Year.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026")
    @NotNull(message = "Year is required.")
    @Min(value = 2000, message = "Year cannot be less than 2000.")
    @Max(value = 2100, message = "Year cannot be greater than 2100.")
    private Integer year;

    @Schema(description = "Month", requiredMode = Schema.RequiredMode.REQUIRED, example = "7")
    @NotNull(message = "Month is required.")
    @Min(value = 1, message = "Month must be between 1 and 12.")
    @Max(value = 12, message = "Month must be between 1 and 12.")
    private Integer month;

    @Schema(description = "Title.", example = "July 2026 payroll")
    @Size(max = 128, message = "Title cannot exceed 128 characters.")
    private String title;

    @Schema(description = "Start Date.")
    private LocalDateTime startTime;

    @Schema(description = "End Date.")
    private LocalDateTime endTime;

}
