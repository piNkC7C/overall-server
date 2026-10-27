package cn.iocoder.yudao.module.wms.controller.admin.order.receipt.vo.order;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.wms.controller.admin.order.receipt.vo.detail.WmsReceiptOrderDetailSaveReqVO;
import cn.iocoder.yudao.module.wms.enums.order.WmsReceiptOrderTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - WMS inbound order save request.")
@Data
public class WmsReceiptOrderSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Inbound order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "RK202605110001")
    @NotBlank(message = "Inbound order no. is required.")
    @Size(max = 64, message = "Inbound order no. length cannot exceed 64 characters.")
    private String no;

    @Schema(description = "Inbound type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "101")
    @NotNull(message = "Inbound type is required.")
    @InEnum(WmsReceiptOrderTypeEnum.class)
    private Integer type;

    @Schema(description = "Document Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Document Date is required.")
    private LocalDateTime orderTime;

    @Schema(description = "Business order no.", example = "PO202605110001")
    @Size(max = 64, message = "Business order no. length cannot exceed 64 characters.")
    private String bizOrderNo;

    @Schema(description = "Supplier code.", example = "1024")
    private Long merchantId;

    @Schema(description = "Notes.", example = "Notes.")
    @Size(max = 255, message = "Notes length cannot exceed 255 characters.")
    private String remark;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Warehouse is required.")
    private Long warehouseId;

    @Schema(description = "Inbound detail.")
    @Valid
    private List<WmsReceiptOrderDetailSaveReqVO> details;

}
