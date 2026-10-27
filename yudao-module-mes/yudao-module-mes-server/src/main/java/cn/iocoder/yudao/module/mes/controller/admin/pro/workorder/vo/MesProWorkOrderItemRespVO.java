package cn.iocoder.yudao.module.mes.controller.admin.pro.workorder.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES work order material requirement response.")
@Data
public class MesProWorkOrderItemRespVO {

    @Schema(description = "Material code.", example = "100")
    private Long itemId;

    @Schema(description = "Material code.", example = "M-001")
    private String itemCode;

    @Schema(description = "Material name.", example = "10K resistor")
    private String itemName;

    @Schema(description = "Spec / Model", example = "0603")
    private String itemSpecification;

    @Schema(description = "Order characters name.", example = "")
    private String unitMeasureName;

    @Schema(description = "Requirement quantity.", example = "1000.00")
    private BigDecimal quantity;

    @Schema(description = "Material /product key.", example = "ITEM")
    private String itemOrProduct;

}
