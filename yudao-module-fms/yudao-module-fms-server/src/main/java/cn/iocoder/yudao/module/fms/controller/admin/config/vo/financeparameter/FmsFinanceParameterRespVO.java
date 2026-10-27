package cn.iocoder.yudao.module.fms.controller.admin.config.vo.financeparameter;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "FMS finance setting response VO.")
@Data
public class FmsFinanceParameterRespVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long accountSetId;

    @Schema(description = "Account level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4")
    private Integer level;

    @Schema(description = "Account coding rule.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4-2-2-2")
    private String subjectCodeRule;

    @Schema(description = "Book balance-direction mode.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer ledgerBalanceMode;

    @Schema(description = "Closing before is not require journal entry approval.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean voucherReviewRequired;

}
