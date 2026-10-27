package cn.iocoder.yudao.module.mes.controller.admin.wm.packages.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * MES 装箱单新增/修改 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - MES packing order create / edit request.")
@Data
public class MesWmPackageSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Packing order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "PKG20260307001")
    @NotEmpty(message = "Packing order code is required.")
    private String code;

    @Schema(description = "Packing Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Packing Date is required.")
    private LocalDateTime packageDate;

    @Schema(description = "Sales order code.", example = "SO20260301")
    private String salesOrderCode;

    @Schema(description = "Invoice No.", example = "INV20260301")
    private String invoiceCode;

    @Schema(description = "Customer ID.", example = "1")
    private Long clientId;

    @Schema(description = "Box Length", example = "60.00")
    private BigDecimal length;

    @Schema(description = "Box Width", example = "40.00")
    private BigDecimal width;

    @Schema(description = "Box height.", example = "30.00")
    private BigDecimal height;

    @Schema(description = "Size Unit ID.", example = "1")
    private Long sizeUnitId;

    @Schema(description = "Net Weight", example = "10.00")
    private BigDecimal netWeight;

    @Schema(description = "Gross Weight", example = "12.00")
    private BigDecimal grossWeight;

    @Schema(description = "Weight Unit ID.", example = "2")
    private Long weightUnitId;

    @Schema(description = "Inspector user ID.", example = "1")
    private Long inspectorUserId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
