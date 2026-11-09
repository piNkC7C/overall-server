package cn.iocoder.yudao.module.mes.controller.admin.wm.outsourcereceipt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 外协入库单 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesWmOutsourceReceiptRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "入库单编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "OR2026030001")
    @ExcelProperty("Inbound Order Code")
    private String code;

    @Schema(description = "入库单名称", example = "Subcontract inbound")
    @ExcelProperty("Inbound Order Name")
    private String name;

    @Schema(description = "外协工单编号", example = "1")
    private Long workOrderId;

    @Schema(description = "外协工单编码", example = "WO20260301")
    @ExcelProperty("Subcontract Work Order")
    private String workOrderCode;

    @Schema(description = "供应商编号", example = "1")
    private Long vendorId;

    @Schema(description = "供应商名称", example = "A supplier.")
    @ExcelProperty("Supplier")
    private String vendorName;

    @Schema(description = "入库日期")
    @ExcelProperty("Inbound Date")
    private LocalDateTime receiptDate;

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
