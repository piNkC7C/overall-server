package cn.iocoder.yudao.module.mes.controller.admin.wm.productsales.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES sales shipment create / edit request.")
@Data
public class MesWmProductSalesSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Outbound order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "PS2026030001")
    @NotEmpty(message = "Outbound order no. is required.")
    private String code;

    @Schema(description = "Outbound order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Productoutbound order.")
    @NotEmpty(message = "Outbound order name is required.")
    private String name;

    @Schema(description = "CustomerID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Customer is required.")
    private Long clientId;

    @Schema(description = "Sales order no.", example = "SO2026030001")
    private String salesOrderCode;

    @Schema(description = "Outbound Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Outbound Date is required.")
    private LocalDateTime salesDate;

    @Schema(description = "Shipping notification order ID.", example = "1")
    private Long noticeId;

    @Schema(description = "Receiving person.", example = "John.")
    private String contactName;

    @Schema(description = "Contact", example = "13800138000")
    private String contactTelephone;

    @Schema(description = "Receiving Address.", example = "XX Road, District, Seattle")
    private String contactAddress;

    @Schema(description = "Carrier", example = "SF Express")
    private String carrier;

    @Schema(description = "Tracking No.", example = "SF1234567890")
    private String shippingNumber;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
