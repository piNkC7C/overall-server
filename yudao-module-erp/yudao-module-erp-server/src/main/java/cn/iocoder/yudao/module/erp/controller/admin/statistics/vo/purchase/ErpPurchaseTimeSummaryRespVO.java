package cn.iocoder.yudao.module.erp.controller.admin.statistics.vo.purchase;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "ERP purchase period stats response VO.")
@Data
public class ErpPurchaseTimeSummaryRespVO {

    @Schema(description = "Time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2022-03")
    private String time;

    @Schema(description = "Purchase amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private BigDecimal price;

}
