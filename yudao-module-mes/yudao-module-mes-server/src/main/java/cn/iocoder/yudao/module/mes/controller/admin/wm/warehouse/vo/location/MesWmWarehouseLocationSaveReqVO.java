package cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo.location;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES zone create / edit request.")
@Data
public class MesWmWarehouseLocationSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Zone code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "L001")
    @NotEmpty(message = "Zone code is required.")
    private String code;

    @Schema(description = "Zone name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw-material zone")
    @NotEmpty(message = "Zone name is required.")
    private String name;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Warehouse is required.")
    private Long warehouseId;

    @Schema(description = "Area", example = "500.00")
    private BigDecimal area;

    @Schema(description = "Is not freeze.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Is not freeze is required.")
    private Boolean frozen;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    }
