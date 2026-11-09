package cn.iocoder.yudao.module.mes.controller.admin.wm.productsales.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 销售出库单新增/修改 Request VO")
@Data
public class MesWmProductSalesSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "出库单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "PS2026030001")
    @NotEmpty(message = "Outbound order no. is required.")
    private String code;

    @Schema(description = "出库单名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Productoutbound order.")
    @NotEmpty(message = "Outbound order name is required.")
    private String name;

    @Schema(description = "客户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Customer is required.")
    private Long clientId;

    @Schema(description = "销售订单号", example = "SO2026030001")
    private String salesOrderCode;

    @Schema(description = "出库日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Outbound Date is required.")
    private LocalDateTime salesDate;

    @Schema(description = "发货通知单ID", example = "1")
    private Long noticeId;

    @Schema(description = "收货人", example = "John.")
    private String contactName;

    @Schema(description = "联系方式", example = "13800138000")
    private String contactTelephone;

    @Schema(description = "收货地址", example = "XX Road, District, Seattle")
    private String contactAddress;

    @Schema(description = "承运商", example = "SF Express")
    private String carrier;

    @Schema(description = "运输单号", example = "SF1234567890")
    private String shippingNumber;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}
