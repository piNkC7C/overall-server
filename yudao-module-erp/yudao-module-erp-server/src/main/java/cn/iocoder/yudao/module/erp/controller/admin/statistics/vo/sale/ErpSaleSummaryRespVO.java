package cn.iocoder.yudao.module.erp.controller.admin.statistics.vo.sale;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "ERP sales overall stats response VO.")
@Data
public class ErpSaleSummaryRespVO {

    @Schema(description = "Sales Today amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private BigDecimal todayPrice;

    @Schema(description = "Sales Yesterday amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "888")
    private BigDecimal yesterdayPrice;

    @Schema(description = "Sales This Month amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private BigDecimal monthPrice;

    @Schema(description = "Sales This Year amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "88888")
    private BigDecimal yearPrice;

}
