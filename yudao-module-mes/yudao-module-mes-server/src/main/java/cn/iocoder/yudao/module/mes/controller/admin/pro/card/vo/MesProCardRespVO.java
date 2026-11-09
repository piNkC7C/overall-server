package cn.iocoder.yudao.module.mes.controller.admin.pro.card.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 生产流转卡 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesProCardRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "流转卡编码", example = "CARD-001")
    @ExcelProperty("Traveler Card Code")
    private String code;

    @Schema(description = "生产工单编号", example = "100")
    private Long workOrderId;

    @Schema(description = "工单编码", example = "WO-001")
    @ExcelProperty("Work Order Code")
    private String workOrderCode;

    @Schema(description = "工单名称", example = "Production work order-A.")
    @ExcelProperty("Work Order Name")
    private String workOrderName;

    @Schema(description = "产品物料编号", example = "200")
    private Long itemId;

    @Schema(description = "批次号", example = "BATCH-001")
    @ExcelProperty("Lot No")
    private String batchCode;

    @Schema(description = "产品编码", example = "P-001")
    @ExcelProperty("Product Code")
    private String itemCode;

    @Schema(description = "产品名称", example = "PCB A")
    @ExcelProperty("Product Name")
    private String itemName;

    @Schema(description = "规格型号", example = "100x200mm")
    @ExcelProperty("Spec / Model")
    private String specification;

    @Schema(description = "单位编号", example = "300")
    private Long unitMeasureId;

    @Schema(description = "单位名称", example = "")
    @ExcelProperty("Unit")
    private String unitMeasureName;

    @Schema(description = "流转数量", example = "100.00")
    @ExcelProperty("Transfer Quantity")
    private BigDecimal transferedQuantity;

    @Schema(description = "状态", example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
