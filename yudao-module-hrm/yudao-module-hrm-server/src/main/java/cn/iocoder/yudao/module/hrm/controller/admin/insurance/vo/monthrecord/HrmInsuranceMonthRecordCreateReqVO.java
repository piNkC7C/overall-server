package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.monthrecord;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - HRM 月度社保表创建 Request VO")
@Data
public class HrmInsuranceMonthRecordCreateReqVO {

    @Schema(description = "年份", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026")
    @NotNull(message = "Year is required.")
    @Min(value = 2000, message = "Year cannot be less than 2000.")
    @Max(value = 2100, message = "Year cannot be greater than 2100.")
    private Integer year;

    @Schema(description = "月份", requiredMode = Schema.RequiredMode.REQUIRED, example = "7")
    @NotNull(message = "Month is required.")
    @Min(value = 1, message = "Month must be between 1 and 12.")
    @Max(value = 12, message = "Month must be between 1 and 12.")
    private Integer month;

}
