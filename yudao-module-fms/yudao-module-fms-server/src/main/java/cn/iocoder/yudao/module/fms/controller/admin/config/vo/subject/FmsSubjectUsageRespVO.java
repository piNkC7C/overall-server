package cn.iocoder.yudao.module.fms.controller.admin.config.vo.subject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * FMS 科目使用情况 Response VO
 *
 * @author 芋道源码
 */
@Schema(description = "Account usage response VO.")
@Data
public class FmsSubjectUsageRespVO {

    @Schema(description = "Child accountsQuantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Long childCount;

    @Schema(description = "Journal entry entry quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long voucherEntryCount;

    @Schema(description = "Initial balance quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long initialBalanceCount;

    @Schema(description = "Auxiliary combinationQuantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Long auxiliaryCombinationCount;

    @Schema(description = "Include quantity data record quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long quantityDataCount;

    @Schema(description = "Is not is already used by business used.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean used;

}
