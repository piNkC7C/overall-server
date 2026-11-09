package cn.iocoder.yudao.module.mes.controller.admin.wm.productsales.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 销售出库单 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesWmProductSalesRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "出库单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "PS2026030001")
    @ExcelProperty("Outbound Order No")
    private String code;

    @Schema(description = "出库单名称", example = "Productoutbound order.")
    @ExcelProperty("Outbound Order Name")
    private String name;

    @Schema(description = "客户ID", example = "1")
    private Long clientId;

    @Schema(description = "客户名称", example = "A customer.")
    @ExcelProperty("Customer")
    private String clientName;

    @Schema(description = "销售订单号", example = "SO2026030001")
    @ExcelProperty("Sales Order No")
    private String salesOrderCode;

    @Schema(description = "出库日期")
    @ExcelProperty("Outbound Date")
    private LocalDateTime salesDate;

    @Schema(description = "发货通知单ID", example = "1")
    private Long noticeId;

    @Schema(description = "发货通知单编号", example = "SN2026030001")
    @ExcelProperty("Shipping Notice No")
    private String noticeCode;

    @Schema(description = "客户编码", example = "C001")
    @ExcelProperty("Customer Code")
    private String clientCode;

    @Schema(description = "收货人", example = "John.")
    @ExcelProperty("Consignee")
    private String contactName;

    @Schema(description = "联系方式", example = "13800138000")
    @ExcelProperty("Contact Info")
    private String contactTelephone;

    @Schema(description = "收货地址", example = "XX Road, District, Seattle")
    @ExcelProperty("Shipping Address")
    private String contactAddress;

    @Schema(description = "承运商", example = "SF Express")
    @ExcelProperty("Carrier")
    private String carrier;

    @Schema(description = "运输单号", example = "SF1234567890")
    @ExcelProperty("Tracking No")
    private String shippingNumber;

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
