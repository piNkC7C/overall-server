package cn.iocoder.yudao.module.trade.controller.app.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 快递查询的轨迹 Resp DTO
 *
 * @author jason
 */
@Schema(description = "Shipment tracking response VO.")
@Data
public class AppOrderExpressTrackRespDTO {

    @Schema(description = "Occurred at.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime time;

    @Schema(description = "Shipment status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Delivered")
    private String content;

}
