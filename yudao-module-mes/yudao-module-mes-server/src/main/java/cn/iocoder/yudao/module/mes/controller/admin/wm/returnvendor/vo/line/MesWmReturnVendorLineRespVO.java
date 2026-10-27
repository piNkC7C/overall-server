package cn.iocoder.yudao.module.mes.controller.admin.wm.returnvendor.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES supplierreturn order line response.")
@Data
public class MesWmReturnVendorLineRespVO {

    @Schema(description = "Line ID.", example = "1")
    private Long id;

    @Schema(description = "Return orderID.", example = "1")
    private Long returnId;

    @Schema(description = "Material ID.", example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "M001")
    private String itemCode;

    @Schema(description = "Material name.", example = "Steel plate.")
    private String itemName;

    @Schema(description = "Spec / Model", example = "10mm*100mm")
    private String specification;

    @Schema(description = "Unit of measure name.", example = "Kg.")
    private String unitMeasureName;

    @Schema(description = "Return quantity.", example = "100.00")
    private BigDecimal quantity;

    @Schema(description = "LotID.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "BATCH20260101001")
    private String batchCode;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
