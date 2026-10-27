package cn.iocoder.yudao.module.fms.controller.admin.ledger.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(description = "FMS ledger list query request VO.")
@Data
public class FmsLedgerListReqVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Start Accounting Period.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-08")
    @NotNull(message = "Start Accounting Period is required.")
    @Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])", message = "Start Accounting Period format is invalid.")
    private String startMonth;

    @Schema(description = "End Accounting Period.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-12")
    @NotNull(message = "End Accounting Period is required.")
    @Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])", message = "End Accounting Period format is invalid.")
    private String endMonth;

    @Schema(description = "Account code.", example = "1024")
    private Long subjectId;

    @Schema(description = "Start account ID.", example = "1024")
    private Long startSubjectId;

    @Schema(description = "End account code.", example = "2048")
    private Long endSubjectId;

    @Schema(description = "Minimum account level.", example = "1")
    @Min(value = 1, message = "Minimum account level cannot be less than 1.")
    @Max(value = 10, message = "Minimum account level cannot be greater than 10.")
    private Integer minLevel;

    @Schema(description = "Maximum account level.", example = "4")
    @Min(value = 1, message = "Maximum account level cannot be less than 1.")
    @Max(value = 10, message = "Maximum account level cannot be greater than 10.")
    private Integer maxLevel;

}
