package cn.iocoder.yudao.module.mes.controller.admin.pro.workorder.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES production work order response.")
@Data
@ExcelIgnoreUnannotated
public class MesProWorkOrderRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Work order code.", example = "WO-001")
    @ExcelProperty("Work Order Code")
    private String code;

    @Schema(description = "Work order name.", example = "Production work order-A.")
    @ExcelProperty("Work Order Name")
    private String name;

    @Schema(description = "Work order type.", example = "1")
    @ExcelProperty(value = "Work Order Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_PRO_WORK_ORDER_TYPE)
    private Integer type;

    @Schema(description = "Source type.", example = "1")
    @ExcelProperty(value = "Source Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_PRO_WORK_ORDER_SOURCE_TYPE)
    private Integer orderSourceType;

    @Schema(description = "Source document code.", example = "SO-001")
    @ExcelProperty("Source Document No")
    private String orderSourceCode;

    @Schema(description = "Product code.", example = "100")
    private Long productId;

    @Schema(description = "Product name.", example = "PCB A")
    @ExcelProperty("Product Name")
    private String productName;

    @Schema(description = "Product code.", example = "P-001")
    @ExcelProperty("Product Code")
    private String productCode;

    @Schema(description = "Spec / Model", example = "100x200mm")
    @ExcelProperty("Spec / Model")
    private String productSpecification;

    @Schema(description = "Order characters name.", example = "")
    @ExcelProperty("Unit")
    private String unitMeasureName;

    @Schema(description = "Production quantity.", example = "100.00")
    @ExcelProperty("Production Quantity")
    private BigDecimal quantity;

    @Schema(description = "Already production quantity.", example = "50.00")
    @ExcelProperty("Produced Quantity")
    private BigDecimal quantityProduced;

    @Schema(description = "Adjust quantity.", example = "0")
    @ExcelProperty("Adjustment Quantity")
    private BigDecimal quantityChanged;

    @Schema(description = "Already Scheduled Qty.", example = "80.00")
    @ExcelProperty("Scheduled Quantity")
    private BigDecimal quantityScheduled;

    @Schema(description = "Customer code.", example = "300")
    private Long clientId;

    @Schema(description = "Customer code.", example = "C-001")
    @ExcelProperty("Customer Code")
    private String clientCode;

    @Schema(description = "Customer name.", example = "Customer A.")
    @ExcelProperty("Customer Name")
    private String clientName;

    @Schema(description = "Supplier code.", example = "400")
    private Long vendorId;

    @Schema(description = "Supplier code.", example = "V-001")
    @ExcelProperty("Supplier Code")
    private String vendorCode;

    @Schema(description = "Supplier name.", example = "Supplier A.")
    @ExcelProperty("Supplier Name")
    private String vendorName;

    @Schema(description = "Lot no.", example = "BATCH-001")
    @ExcelProperty("Lot No")
    private String batchCode;

    @Schema(description = "Need-by Date")
    @ExcelProperty("Need-by Date")
    private LocalDateTime requestDate;

    @Schema(description = "Parent work order code.", example = "0")
    private Long parentId;

    @Schema(description = "Parent work order code.", example = "WO-001")
    private String parentCode;

    @Schema(description = "Complete time.")
    @ExcelProperty("Completed Time")
    private LocalDateTime finishDate;

    @Schema(description = "Cancel time.")
    @ExcelProperty("Cancel Time")
    private LocalDateTime cancelDate;

    @Schema(description = "Work order status.", example = "0")
    @ExcelProperty(value = "Work Order Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_PRO_WORK_ORDER_STATUS)
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
