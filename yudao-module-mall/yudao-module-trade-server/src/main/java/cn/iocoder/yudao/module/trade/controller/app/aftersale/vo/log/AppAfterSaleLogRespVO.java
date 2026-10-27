package cn.iocoder.yudao.module.trade.controller.app.aftersale.vo.log;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "App after-sale log response VO.")
@Data
public class AppAfterSaleLogRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20669")
    private Long id;

    @Schema(description = "Actiondetail.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Dispute closed. Refund amount: $377.76")
    private String content;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
