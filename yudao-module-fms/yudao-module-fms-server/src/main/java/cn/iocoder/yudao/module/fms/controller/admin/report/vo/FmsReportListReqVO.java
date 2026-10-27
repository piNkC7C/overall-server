package cn.iocoder.yudao.module.fms.controller.admin.report.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(description = "Financial-statement query request VO.")
@Data
public class FmsReportListReqVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Start Accounting Period.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-08")
    @NotNull(message = "Start Accounting Period is required.")
    @Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])", message = "Start Accounting Period format is invalid.")
    private String startMonth;

    @Schema(description = "End Accounting Period.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-08")
    @NotNull(message = "End Accounting Period is required.")
    @Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])", message = "End Accounting Period format is invalid.")
    private String endMonth;

}
