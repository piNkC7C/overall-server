package cn.iocoder.yudao.module.mes.controller.admin.tm.tool.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "MES tool ledger create / update request VO.")
@Data
public class MesTmToolSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Tool code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "T-001")
    @NotEmpty(message = "Tool code is required.")
    @Size(max = 64, message = "Tool code length cannot exceed 64 characters.")
    private String code;

    @Schema(description = "Tool name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5mm end mill")
    @NotEmpty(message = "Tool name is required.")
    @Size(max = 255, message = "Tool name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "Brand.", example = "Mitsubishi")
    @Size(max = 255, message = "Brand length cannot exceed 255 characters.")
    private String brand;

    @Schema(description = "Model / Spec", example = "M5-100")
    @Size(max = 255, message = "Model / Spec length cannot exceed 255 characters.")
    private String specification;

    @Schema(description = "Tool type code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Tool type is required.")
    private Long toolTypeId;

    @Schema(description = "Quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Quantity is required.")
    private Integer quantity;

    @Schema(description = "Can quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Can quantity is required.")
    private Integer availableQuantity;

    @Schema(description = "Maintenance Type", example = "1")
    private Integer maintenType;

    @Schema(description = "Next maintenance cycle (count).", example = "100")
    private Integer nextMaintenPeriod;

    @Schema(description = "Times maintenance Date.", example = "2024-06-01 00:00:00")
    private LocalDateTime nextMaintenDate;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

}