package cn.iocoder.yudao.module.mes.controller.admin.wm.productsales.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - MES 销售出库单填写运单 Request VO")
@Data
public class MesWmProductSalesShippingReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "承运商", example = "SF Express")
    private String carrier;

    @Schema(description = "运输单号", example = "SF1234567890")
    private String shippingNumber;

}
