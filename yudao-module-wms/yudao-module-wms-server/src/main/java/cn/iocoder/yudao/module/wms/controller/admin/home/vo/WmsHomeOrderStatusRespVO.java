package cn.iocoder.yudao.module.wms.controller.admin.home.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - WMS Home document statusStats response.")
@Data
public class WmsHomeOrderStatusRespVO {

    @Schema(description = "StatusValue.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Document quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12")
    private Long count;

}
