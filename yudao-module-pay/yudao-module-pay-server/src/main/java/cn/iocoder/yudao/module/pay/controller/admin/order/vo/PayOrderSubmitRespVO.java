package cn.iocoder.yudao.module.pay.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - payment submit response.")
@Data
public class PayOrderSubmitRespVO {

    @Schema(description = "Payment status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10") // See PayOrderStatusEnum enum
    private Integer status;

    @Schema(description = "Display mode.", requiredMode = Schema.RequiredMode.REQUIRED, example = "url") // See PayDisplayModeEnum enum
    private String displayMode;
    @Schema(description = "Display content.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String displayContent;

}
