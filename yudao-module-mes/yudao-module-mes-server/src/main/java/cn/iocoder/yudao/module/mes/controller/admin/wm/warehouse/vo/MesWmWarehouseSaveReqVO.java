package cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES warehouse create / edit request.")
@Data
public class MesWmWarehouseSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WH001")
    @NotEmpty(message = "Warehouse code is required.")
    private String code;

    @Schema(description = "Warehouse name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw Materials.")
    @NotEmpty(message = "Warehouse name is required.")
    private String name;

    @Schema(description = "WarehouseAddress.", example = "Building 1, Zone A")
    private String address;

    @Schema(description = "Area", example = "1200.50")
    private BigDecimal area;

    @Schema(description = "Owner person user ID.", example = "1")
    private Long chargeUserId;

    @Schema(description = "Is not freeze.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Is not freeze is required.")
    private Boolean frozen;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    }
