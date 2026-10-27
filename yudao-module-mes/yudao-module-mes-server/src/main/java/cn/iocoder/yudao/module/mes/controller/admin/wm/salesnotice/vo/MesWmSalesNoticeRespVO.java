package cn.iocoder.yudao.module.mes.controller.admin.wm.salesnotice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES shipping notification order response.")
@Data
@ExcelIgnoreUnannotated
public class MesWmSalesNoticeRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Notification order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "SN202603010001")
    @ExcelProperty("Notice Code")
    private String code;

    @Schema(description = "Notification order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test shipment notice")
    @ExcelProperty("Notice Name")
    private String name;

    @Schema(description = "Sales order code.", example = "SO202603010001")
    @ExcelProperty("Sales Order No")
    private String salesOrderCode;

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long clientId;

    @Schema(description = "Customer code.", example = "C001")
    @ExcelProperty("Customer Code")
    private String clientCode;

    @Schema(description = "Customer name.", example = "A customer.")
    @ExcelProperty("Customer Name")
    private String clientName;

    @Schema(description = "Shipping Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Ship Date")
    private LocalDateTime salesDate;

    @Schema(description = "Receiving person.", example = "John.")
    @ExcelProperty("Consignee")
    private String recipientName;

    @Schema(description = "Contact", example = "13800138000")
    @ExcelProperty("Contact Info")
    private String recipientTelephone;

    @Schema(description = "Receiving Address.", example = "District xxx, Seattle")
    @ExcelProperty("Shipping Address")
    private String recipientAddress;

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
