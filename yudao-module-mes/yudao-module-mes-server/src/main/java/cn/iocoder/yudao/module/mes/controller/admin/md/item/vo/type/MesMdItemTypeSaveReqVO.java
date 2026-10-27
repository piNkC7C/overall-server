package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.type;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES material product category create / edit request.")
@Data
public class MesMdItemTypeSaveReqVO {

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Parent category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Parent category code is required.")
    private Long parentId;

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "RAW")
    @NotEmpty(message = "Category code is required.")
    private String code;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw material")
    @NotEmpty(message = "Category name is required.")
    private String name;

    @Schema(description = "Material /product key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ITEM")
    @NotEmpty(message = "Material /product key is required.")
    private String itemOrProduct;

    @Schema(description = "Show sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Show sort is required.")
    private Integer sort;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    }
