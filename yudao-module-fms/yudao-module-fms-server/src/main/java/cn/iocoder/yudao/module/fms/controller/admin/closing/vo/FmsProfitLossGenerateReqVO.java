package cn.iocoder.yudao.module.fms.controller.admin.closing.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(description = "Admin - FMS create close P&L journal entry request.")
@Data
public class FmsProfitLossGenerateReqVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books is required.")
    private Long accountSetId;

    @Schema(description = "Accounting Period", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-08")
    @NotBlank(message = "Accounting Period is required.")
    @Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])", message = "Accounting Period format is invalid.")
    private String month;

}
