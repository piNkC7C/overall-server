package cn.iocoder.yudao.module.erp.controller.admin.statistics.vo.sale;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "ERP sales period stats response VO.")
@Data
public class ErpSaleTimeSummaryRespVO {

    @Schema(description = "Time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2022-03")
    private String time;

    @Schema(description = "Sales amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private BigDecimal price;

}
