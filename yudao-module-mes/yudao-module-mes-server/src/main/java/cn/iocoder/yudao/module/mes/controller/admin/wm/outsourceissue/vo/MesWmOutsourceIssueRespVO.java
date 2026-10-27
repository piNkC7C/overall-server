package cn.iocoder.yudao.module.mes.controller.admin.wm.outsourceissue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES subcontract issue order response.")
@Data
@ExcelIgnoreUnannotated
public class MesWmOutsourceIssueRespVO {

    @Schema(description = "Issue materials order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Material Issue ID")
    private Long id;

    @Schema(description = "Issue materials order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WOS202603020001")
    @ExcelProperty("Material Issue No")
    private String code;

    @Schema(description = "Issue materials order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Subcontract issue order 001.")
    @ExcelProperty("Material Issue Name")
    private String name;

    @Schema(description = "SupplierID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long vendorId;

    @Schema(description = "Supplier code.", example = "V001")
    @ExcelProperty("Supplier Code")
    private String vendorCode;

    @Schema(description = "Supplier name.", example = "SupplierA.")
    @ExcelProperty("Supplier Name")
    private String vendorName;

    @Schema(description = "Production work orderID.", example = "1")
    private Long workOrderId;

    @Schema(description = "Production work order code.", example = "WO202603020001")
    @ExcelProperty("Production Work Order Code")
    private String workOrderCode;

    @Schema(description = "Production work order name.", example = "Production work order001.")
    @ExcelProperty("Production Work Order Name")
    private String workOrderName;

    @Schema(description = "Issue materials Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Issue Date")
    private LocalDateTime issueDate;

    @Schema(description = "Document status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Document Status")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
