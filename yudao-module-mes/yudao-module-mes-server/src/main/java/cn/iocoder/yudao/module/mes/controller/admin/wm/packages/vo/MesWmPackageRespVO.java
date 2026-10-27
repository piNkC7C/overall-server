package cn.iocoder.yudao.module.mes.controller.admin.wm.packages.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * MES 装箱单 Response VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - MES packing order response.")
@Data
@Accessors(chain = true)
@ExcelIgnoreUnannotated
public class MesWmPackageRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Packing order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "PKG20260307001")
    @ExcelProperty("Packing List No")
    private String code;

    @Schema(description = "Parent box ID.", example = "0")
    private Long parentId;

    @Schema(description = "Packing Date.")
    @ExcelProperty("Packing Date")
    private LocalDateTime packageDate;

    @Schema(description = "Sales order code.", example = "SO20260301")
    @ExcelProperty("Sales Order No")
    private String salesOrderCode;

    @Schema(description = "Invoice No.", example = "INV20260301")
    @ExcelProperty("Invoice No")
    private String invoiceCode;

    @Schema(description = "Customer ID.", example = "1")
    private Long clientId;

    @Schema(description = "Customer code.", example = "C001")
    @ExcelProperty("Customer Code")
    private String clientCode;

    @Schema(description = "Customer name.", example = "A customer.")
    @ExcelProperty("Customer Name")
    private String clientName;

    @Schema(description = "Customer short name.", example = "A customer short name.")
    private String clientNickname;

    @Schema(description = "Box Length", example = "60.00")
    @ExcelProperty("Box Length")
    private BigDecimal length;

    @Schema(description = "Box Width", example = "40.00")
    @ExcelProperty("Box Width")
    private BigDecimal width;

    @Schema(description = "Box height.", example = "30.00")
    @ExcelProperty("Box Height")
    private BigDecimal height;

    @Schema(description = "Size Unit ID.", example = "1")
    private Long sizeUnitId;

    @Schema(description = "Size Unit name.", example = "cm")
    @ExcelProperty("Size Unit")
    private String sizeUnitName;

    @Schema(description = "Net Weight", example = "10.00")
    @ExcelProperty("Net Weight")
    private BigDecimal netWeight;

    @Schema(description = "Gross Weight", example = "12.00")
    @ExcelProperty("Gross Weight")
    private BigDecimal grossWeight;

    @Schema(description = "Weight Unit ID.", example = "2")
    private Long weightUnitId;

    @Schema(description = "Weight Unit name.", example = "Kg.")
    @ExcelProperty("Weight Unit")
    private String weightUnitName;

    @Schema(description = "Inspector user ID.", example = "1")
    private Long inspectorUserId;

    @Schema(description = "Inspector Name.", example = "John.")
    @ExcelProperty("Inspector")
    private String inspectorName;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
