package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - BPM workflowcategory response.")
@Data
public class BpmCategoryRespVO {

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3167")
    private Long id;

    @Schema(description = "Category Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    private String name;

    @Schema(description = "Category Key", requiredMode = Schema.RequiredMode.REQUIRED, example = "OA")
    private String code;

    @Schema(description = "CategoryDescription.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Example.")
    private String description;

    @Schema(description = "Category status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Category sort.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer sort;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}