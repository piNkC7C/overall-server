package cn.iocoder.yudao.module.mes.controller.admin.wm.productsales.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES sales shipment response.")
@Data
@ExcelIgnoreUnannotated
public class MesWmProductSalesRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Outbound order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "PS2026030001")
    @ExcelProperty("Outbound Order No")
    private String code;

    @Schema(description = "Outbound order name.", example = "Productoutbound order.")
    @ExcelProperty("Outbound Order Name")
    private String name;

    @Schema(description = "CustomerID.", example = "1")
    private Long clientId;

    @Schema(description = "Customer name.", example = "A customer.")
    @ExcelProperty("Customer")
    private String clientName;

    @Schema(description = "Sales order no.", example = "SO2026030001")
    @ExcelProperty("Sales Order No")
    private String salesOrderCode;

    @Schema(description = "Outbound Date")
    @ExcelProperty("Outbound Date")
    private LocalDateTime salesDate;

    @Schema(description = "Shipping notification order ID.", example = "1")
    private Long noticeId;

    @Schema(description = "Shipping notification order code.", example = "SN2026030001")
    @ExcelProperty("Shipping Notice No")
    private String noticeCode;

    @Schema(description = "Customer code.", example = "C001")
    @ExcelProperty("Customer Code")
    private String clientCode;

    @Schema(description = "Receiving person.", example = "John.")
    @ExcelProperty("Consignee")
    private String contactName;

    @Schema(description = "Contact", example = "13800138000")
    @ExcelProperty("Contact Info")
    private String contactTelephone;

    @Schema(description = "Receiving Address.", example = "XX Road, District, Seattle")
    @ExcelProperty("Shipping Address")
    private String contactAddress;

    @Schema(description = "Carrier", example = "SF Express")
    @ExcelProperty("Carrier")
    private String carrier;

    @Schema(description = "Tracking No.", example = "SF1234567890")
    @ExcelProperty("Tracking No")
    private String shippingNumber;

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
