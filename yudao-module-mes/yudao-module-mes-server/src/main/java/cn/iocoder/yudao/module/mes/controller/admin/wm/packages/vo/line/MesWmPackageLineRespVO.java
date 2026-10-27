package cn.iocoder.yudao.module.mes.controller.admin.wm.packages.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * MES 装箱明细 Response VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - MES packing detail response.")
@Data
@Accessors(chain = true)
public class MesWmPackageLineRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Packing order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long packageId;

    @Schema(description = "Inventoryrecord ID.", example = "1")
    private Long materialStockId;

    @Schema(description = "Product material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "M001")
    private String itemCode;

    @Schema(description = "Material name.", example = "Bolt")
    private String itemName;

    @Schema(description = "Spec / Model", example = "M10*50")
    private String specification;

    @Schema(description = "Unit of measure name.", example = "")
    private String unitMeasureName;

    @Schema(description = "Packing quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    private BigDecimal quantity;

    @Schema(description = "Production work order ID.", example = "1")
    private Long workOrderId;

    @Schema(description = "Production work order code.", example = "WO20260301")
    private String workOrderCode;

    @Schema(description = "Lot no.", example = "BATCH001")
    private String batchCode;

    @Schema(description = "Expiration date.")
    private LocalDateTime expireDate;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
