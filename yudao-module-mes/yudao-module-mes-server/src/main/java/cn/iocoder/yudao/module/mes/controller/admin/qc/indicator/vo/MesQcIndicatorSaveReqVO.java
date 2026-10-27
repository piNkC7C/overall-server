package cn.iocoder.yudao.module.mes.controller.admin.qc.indicator.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES quality inspection metric create / edit request.")
@Data
public class MesQcIndicatorSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Inspect item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "QI001")
    @NotEmpty(message = "Inspect item code is required.")
    private String code;

    @Schema(description = "Inspect item name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Length.")
    @NotEmpty(message = "Inspect item name is required.")
    private String name;

    @Schema(description = "Inspect item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inspect item type is required.")
    private Integer type;

    @Schema(description = "Inspect tool.", example = "Caliper")
    private String tool;

    @Schema(description = "Result value type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Result value type cannot be empty.")
    private Integer resultType;

    @Schema(description = "Result-value property.", example = "IMG")
    private String resultSpecification;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    }
