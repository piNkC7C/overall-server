package cn.iocoder.yudao.module.pay.controller.admin.transfer.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - start transfer response.")
@Data
public class PayTransferCreateRespVO {

    @Schema(description = "Transfer order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Transfer status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1") // See PayTransferStatusEnum enum
    private Integer status;

}
