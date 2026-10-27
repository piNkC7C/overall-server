package cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - WMS product category response.")
@Data
public class WmsItemCategoryRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Parent code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Long parentId;

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "C00000001")
    private String code;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw material")
    private String name;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sort;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
