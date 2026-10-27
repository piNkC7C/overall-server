package cn.iocoder.yudao.module.erp.controller.admin.statistics.vo.purchase;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "ERP purchase overall stats response VO.")
@Data
public class ErpPurchaseSummaryRespVO {

    @Schema(description = "Purchases Today amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private BigDecimal todayPrice;

    @Schema(description = "Purchases Yesterday amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "888")
    private BigDecimal yesterdayPrice;

    @Schema(description = "Purchases This Month amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private BigDecimal monthPrice;

    @Schema(description = "Purchases This Year amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "88888")
    private BigDecimal yearPrice;

}
