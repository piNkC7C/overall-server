package cn.iocoder.yudao.module.mes.controller.admin.wm.outsourceissue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 外协发料单 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesWmOutsourceIssueRespVO {

    @Schema(description = "发料单ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Material Issue ID")
    private Long id;

    @Schema(description = "发料单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "WOS202603020001")
    @ExcelProperty("Material Issue No")
    private String code;

    @Schema(description = "发料单名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Subcontract issue order 001.")
    @ExcelProperty("Material Issue Name")
    private String name;

    @Schema(description = "供应商ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long vendorId;

    @Schema(description = "供应商编码", example = "V001")
    @ExcelProperty("Supplier Code")
    private String vendorCode;

    @Schema(description = "供应商名称", example = "SupplierA.")
    @ExcelProperty("Supplier Name")
    private String vendorName;

    @Schema(description = "生产工单ID", example = "1")
    private Long workOrderId;

    @Schema(description = "生产工单编码", example = "WO202603020001")
    @ExcelProperty("Production Work Order Code")
    private String workOrderCode;

    @Schema(description = "生产工单名称", example = "Production work order001.")
    @ExcelProperty("Production Work Order Name")
    private String workOrderName;

    @Schema(description = "发料日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Issue Date")
    private LocalDateTime issueDate;

    @Schema(description = "单据状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Document Status")
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
