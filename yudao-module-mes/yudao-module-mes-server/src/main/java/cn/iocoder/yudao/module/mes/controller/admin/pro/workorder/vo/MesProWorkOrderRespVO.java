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

@Schema(description = "管理后台 - MES 生产工单 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesProWorkOrderRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "工单编码", example = "WO-001")
    @ExcelProperty("Work Order Code")
    private String code;

    @Schema(description = "工单名称", example = "Production work order-A.")
    @ExcelProperty("Work Order Name")
    private String name;

    @Schema(description = "工单类型", example = "1")
    @ExcelProperty(value = "Work Order Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_PRO_WORK_ORDER_TYPE)
    private Integer type;

    @Schema(description = "来源类型", example = "1")
    @ExcelProperty(value = "Source Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_PRO_WORK_ORDER_SOURCE_TYPE)
    private Integer orderSourceType;

    @Schema(description = "来源单据编号", example = "SO-001")
    @ExcelProperty("Source Document No")
    private String orderSourceCode;

    @Schema(description = "产品编号", example = "100")
    private Long productId;

    @Schema(description = "产品名称", example = "PCB A")
    @ExcelProperty("Product Name")
    private String productName;

    @Schema(description = "产品编码", example = "P-001")
    @ExcelProperty("Product Code")
    private String productCode;

    @Schema(description = "规格型号", example = "100x200mm")
    @ExcelProperty("Spec / Model")
    private String productSpecification;

    @Schema(description = "单位名称", example = "")
    @ExcelProperty("Unit")
    private String unitMeasureName;

    @Schema(description = "生产数量", example = "100.00")
    @ExcelProperty("Production Quantity")
    private BigDecimal quantity;

    @Schema(description = "已生产数量", example = "50.00")
    @ExcelProperty("Produced Quantity")
    private BigDecimal quantityProduced;

    @Schema(description = "调整数量", example = "0")
    @ExcelProperty("Adjustment Quantity")
    private BigDecimal quantityChanged;

    @Schema(description = "已排产数量", example = "80.00")
    @ExcelProperty("Scheduled Quantity")
    private BigDecimal quantityScheduled;

    @Schema(description = "客户编号", example = "300")
    private Long clientId;

    @Schema(description = "客户编码", example = "C-001")
    @ExcelProperty("Customer Code")
    private String clientCode;

    @Schema(description = "客户名称", example = "Customer A.")
    @ExcelProperty("Customer Name")
    private String clientName;

    @Schema(description = "供应商编号", example = "400")
    private Long vendorId;

    @Schema(description = "供应商编码", example = "V-001")
    @ExcelProperty("Supplier Code")
    private String vendorCode;

    @Schema(description = "供应商名称", example = "Supplier A.")
    @ExcelProperty("Supplier Name")
    private String vendorName;

    @Schema(description = "批次号", example = "BATCH-001")
    @ExcelProperty("Lot No")
    private String batchCode;

    @Schema(description = "需求日期")
    @ExcelProperty("Need-by Date")
    private LocalDateTime requestDate;

    @Schema(description = "父工单编号", example = "0")
    private Long parentId;

    @Schema(description = "父工单编码", example = "WO-001")
    private String parentCode;

    @Schema(description = "完成时间")
    @ExcelProperty("Completed Time")
    private LocalDateTime finishDate;

    @Schema(description = "取消时间")
    @ExcelProperty("Cancel Time")
    private LocalDateTime cancelDate;

    @Schema(description = "工单状态", example = "0")
    @ExcelProperty(value = "Work Order Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_PRO_WORK_ORDER_STATUS)
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
