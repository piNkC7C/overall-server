package cn.iocoder.yudao.module.wms.controller.admin.order.check.vo.order;

import cn.iocoder.yudao.module.wms.controller.admin.order.check.vo.detail.WmsCheckOrderDetailSaveReqVO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - WMS inventory count order save request.")
@Data
public class WmsCheckOrderSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Inventory count order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "PK202605110001")
    @NotBlank(message = "Inventory count order no. is required.")
    @Size(max = 64, message = "Inventory count order no. length cannot exceed 64 characters.")
    private String no;

    @Schema(description = "Document Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Document Date is required.")
    private LocalDateTime orderTime;

    @Schema(description = "Notes.", example = "Notes.")
    @Size(max = 255, message = "Notes length cannot exceed 255 characters.")
    private String remark;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Warehouse is required.")
    private Long warehouseId;

    @Schema(description = "Inventory count detail.")
    @Valid
    private List<WmsCheckOrderDetailSaveReqVO> details;

}
