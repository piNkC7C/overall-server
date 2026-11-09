package cn.iocoder.yudao.module.mes.controller.admin.qc.oqc.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 出货检验单 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesQcOqcRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "检验单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "OQC20250101001")
    @ExcelProperty("Inspection No")
    private String code;

    @Schema(description = "检验单名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Material A outgoing inspection")
    @ExcelProperty("Inspection Name")
    private String name;

    @Schema(description = "检验模板 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long templateId;

    // ========== source document ==========

    @Schema(description = "来源单据类型", example = "118")
    private Integer sourceDocType;

    @Schema(description = "来源单据 ID", example = "200")
    private Long sourceDocId;

    @Schema(description = "来源单据行 ID", example = "300")
    private Long sourceLineId;

    @Schema(description = "来源单据编号", example = "DOC20250101001")
    private String sourceDocCode;

    // ========== customer ==========

    @Schema(description = "客户 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long clientId;

    @Schema(description = "客户简称", example = "CustomerA.")
    @ExcelProperty("Customer Short Name")
    private String clientNickname;

    // ========== material ==========

    @Schema(description = "批次号", example = "BC20250101")
    @ExcelProperty("Lot No")
    private String batchCode;

    @Schema(description = "产品物料 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Long itemId;

    @Schema(description = "产品物料编码", example = "ITEM001")
    @ExcelProperty("Product Material Code")
    private String itemCode;

    @Schema(description = "产品物料名称", example = "Material A.")
    @ExcelProperty("Product Material Name")
    private String itemName;

    @Schema(description = "规格型号", example = "100mm*50mm")
    private String itemSpecification;

    @Schema(description = "单位名称", example = "")
    private String unitName;

    // ========== quantity ==========

    @Schema(description = "最低检测数", example = "5")
    private Integer minCheckQuantity;

    @Schema(description = "最大不合格数", example = "0")
    private Integer maxUnqualifiedQuantity;

    @Schema(description = "本次出货数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @ExcelProperty("Shipment Quantity")
    private BigDecimal outQuantity;

    @Schema(description = "本次检测数量", example = "10")
    @ExcelProperty("Inspected Quantity")
    private BigDecimal checkQuantity;

    @Schema(description = "合格品数量", example = "9")
    @ExcelProperty("Passed Quantity")
    private BigDecimal qualifiedQuantity;

    @Schema(description = "不合格品数量", example = "1")
    @ExcelProperty("Failed Quantity")
    private BigDecimal unqualifiedQuantity;

    // ========== defect Stats ==========

    @Schema(description = "致命缺陷率（%）", example = "0.00")
    private BigDecimal criticalRate;

    @Schema(description = "严重缺陷率（%）", example = "0.00")
    private BigDecimal majorRate;

    @Schema(description = "轻微缺陷率（%）", example = "10.00")
    private BigDecimal minorRate;

    @Schema(description = "致命缺陷数量", example = "0")
    private Integer criticalQuantity;

    @Schema(description = "严重缺陷数量", example = "0")
    private Integer majorQuantity;

    @Schema(description = "轻微缺陷数量", example = "1")
    private Integer minorQuantity;

    // ========== inspection ==========

    @Schema(description = "检测结果", example = "1")
    @ExcelProperty("Inspection Result")
    private Integer checkResult;

    @Schema(description = "出货日期")
    @ExcelProperty("Shipment Date")
    private LocalDateTime outDate;

    @Schema(description = "检测日期")
    @ExcelProperty("Inspection Date")
    private LocalDateTime inspectDate;

    @Schema(description = "检测人员用户 ID", example = "1")
    private Long inspectorUserId;

    @Schema(description = "检测人员昵称", example = "John.")
    @ExcelProperty("Inspector")
    private String inspectorNickname;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
