package cn.iocoder.yudao.module.statistics.controller.admin.pay.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - payment Stats response.")
@Data
public class PaySummaryRespVO {

    @Schema(description = "Top-up amount, order characters Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer rechargePrice;

}
