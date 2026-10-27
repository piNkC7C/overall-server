package cn.iocoder.yudao.module.mes.controller.admin.wm.productsales.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES sales shipment line response.")
@Data
public class MesWmProductSalesLineRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Outbound orderID.", example = "1")
    private Long salesId;

    @Schema(description = "Shipping notification order line ID.", example = "1")
    private Long noticeLineId;

    @Schema(description = "Material ID.", example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "M001")
    private String itemCode;

    @Schema(description = "Material name.", example = "ProductA.")
    private String itemName;

    @Schema(description = "Spec / Model", example = "100g")
    private String specification;

    @Schema(description = "Order characters name.", example = "")
    private String unitMeasureName;

    @Schema(description = "Outbound quantity.", example = "100")
    private BigDecimal quantity;

    @Schema(description = "LotID.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "B20260301001")
    private String batchCode;

    @Schema(description = "Outgoing factory inspection.", example = "true")
    private Boolean oqcCheckFlag;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
