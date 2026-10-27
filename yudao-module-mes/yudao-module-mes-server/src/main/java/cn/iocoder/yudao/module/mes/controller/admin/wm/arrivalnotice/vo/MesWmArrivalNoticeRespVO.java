package cn.iocoder.yudao.module.mes.controller.admin.wm.arrivalnotice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES receiving notification order response.")
@Data
@ExcelIgnoreUnannotated
public class MesWmArrivalNoticeRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Notification order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "AN2026020001")
    @ExcelProperty("Notice Code")
    private String code;

    @Schema(description = "Notification order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2 Monthsteel plate receiving.")
    @ExcelProperty("Notice Name")
    private String name;

    @Schema(description = "Purchase order code.", example = "PO20260101")
    @ExcelProperty("Purchase Order No")
    private String purchaseOrderCode;

    @Schema(description = "Supplier code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long vendorId;

    @Schema(description = "Supplier code.", example = "V001")
    @ExcelProperty("Supplier Code")
    private String vendorCode;

    @Schema(description = "Supplier name.", example = "A supplier.")
    @ExcelProperty("Supplier Name")
    private String vendorName;

    @Schema(description = "Receiving Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Arrival Date")
    private LocalDateTime arrivalDate;

    @Schema(description = "Contact.", example = "John.")
    @ExcelProperty("Contact")
    private String contactName;

    @Schema(description = "Phone", example = "13800138000")
    @ExcelProperty("Phone")
    private String contactTelephone;

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
