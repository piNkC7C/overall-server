package cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo.area;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES bin create / edit request.")
@Data
public class MesWmWarehouseAreaSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Bin code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "A001")
    @NotEmpty(message = "Bin code is required.")
    private String code;

    @Schema(description = "Bin name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Default bin.")
    @NotEmpty(message = "Bin name is required.")
    private String name;

    @Schema(description = "Zone code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Zone is required.")
    private Long locationId;

    @Schema(description = "Area", example = "20.00")
    private BigDecimal area;

    @Schema(description = "Maximum load.", example = "1000.00")
    private BigDecimal maxLoad;

    @Schema(description = "Location X.", example = "1")
    private Integer positionX;

    @Schema(description = "Location Y.", example = "1")
    private Integer positionY;

    @Schema(description = "Location Z.", example = "1")
    private Integer positionZ;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Is not freeze.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Is not freeze is required.")
    private Boolean frozen;

    @Schema(description = "Allow mixed materials.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Allow mixed materials cannot be empty.")
    private Boolean allowItemMixing;

    @Schema(description = "Allow mixed lots.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Allow mixed lots cannot be empty.")
    private Boolean allowBatchMixing;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    }
