package cn.iocoder.yudao.module.wms.controller.admin.order.movement.vo.order;

import cn.iocoder.yudao.module.wms.controller.admin.order.movement.vo.detail.WmsMovementOrderDetailSaveReqVO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - WMS warehouse transfer order save request.")
@Data
public class WmsMovementOrderSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Warehouse transfer order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "YK202605110001")
    @NotBlank(message = "Warehouse transfer order no. is required.")
    @Size(max = 64, message = "Warehouse transfer order no. length cannot exceed 64 characters.")
    private String no;

    @Schema(description = "Document Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Document Date is required.")
    private LocalDateTime orderTime;

    @Schema(description = "Notes.", example = "Notes.")
    @Size(max = 255, message = "Notes length cannot exceed 255 characters.")
    private String remark;

    @Schema(description = "Source warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Source warehouse is required.")
    private Long sourceWarehouseId;

    @Schema(description = "Target warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Target warehouse is required.")
    private Long targetWarehouseId;

    @Schema(description = "Warehouse transfer detail.")
    @Valid
    private List<WmsMovementOrderDetailSaveReqVO> details;

}
