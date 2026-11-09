package cn.iocoder.yudao.module.mes.controller.admin.wm.salesnotice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 发货通知单 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesWmSalesNoticeRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "通知单编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "SN202603010001")
    @ExcelProperty("Notice Code")
    private String code;

    @Schema(description = "通知单名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test shipment notice")
    @ExcelProperty("Notice Name")
    private String name;

    @Schema(description = "销售订单编号", example = "SO202603010001")
    @ExcelProperty("Sales Order No")
    private String salesOrderCode;

    @Schema(description = "客户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long clientId;

    @Schema(description = "客户编码", example = "C001")
    @ExcelProperty("Customer Code")
    private String clientCode;

    @Schema(description = "客户名称", example = "A customer.")
    @ExcelProperty("Customer Name")
    private String clientName;

    @Schema(description = "发货日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Ship Date")
    private LocalDateTime salesDate;

    @Schema(description = "收货人", example = "John.")
    @ExcelProperty("Consignee")
    private String recipientName;

    @Schema(description = "联系方式", example = "13800138000")
    @ExcelProperty("Contact Info")
    private String recipientTelephone;

    @Schema(description = "收货地址", example = "District xxx, Seattle")
    @ExcelProperty("Shipping Address")
    private String recipientAddress;

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
