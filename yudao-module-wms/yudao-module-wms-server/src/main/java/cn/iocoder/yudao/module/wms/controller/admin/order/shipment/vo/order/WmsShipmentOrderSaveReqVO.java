package cn.iocoder.yudao.module.wms.controller.admin.order.shipment.vo.order;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.wms.controller.admin.order.shipment.vo.detail.WmsShipmentOrderDetailSaveReqVO;
import cn.iocoder.yudao.module.wms.enums.order.WmsShipmentOrderTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - WMS outbound order save request.")
@Data
public class WmsShipmentOrderSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Outbound order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "CK202605110001")
    @NotBlank(message = "Outbound order no. is required.")
    @Size(max = 64, message = "Outbound order no. length cannot exceed 64 characters.")
    private String no;

    @Schema(description = "Outbound type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "201")
    @NotNull(message = "Outbound type is required.")
    @InEnum(WmsShipmentOrderTypeEnum.class)
    private Integer type;

    @Schema(description = "Document Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Document Date is required.")
    private LocalDateTime orderTime;

    @Schema(description = "Business order no.", example = "SO202605110001")
    @Size(max = 64, message = "Business order no. length cannot exceed 64 characters.")
    private String bizOrderNo;

    @Schema(description = "Customer code.", example = "1024")
    private Long merchantId;

    @Schema(description = "Notes.", example = "Notes.")
    @Size(max = 255, message = "Notes length cannot exceed 255 characters.")
    private String remark;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Warehouse is required.")
    private Long warehouseId;

    @Schema(description = "Outbound detail.")
    @Valid
    private List<WmsShipmentOrderDetailSaveReqVO> details;

}
