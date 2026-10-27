package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.category;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - BPM workflowcategory create / edit request.")
@Data
public class BpmCategorySaveReqVO {

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3167")
    private Long id;

    @Schema(description = "Category Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    @NotEmpty(message = "Category Name is required.")
    private String name;

    @Schema(description = "CategoryDescription.", example = "Example.")
    private String description;

    @Schema(description = "Category Key", requiredMode = Schema.RequiredMode.REQUIRED, example = "OA")
    @NotEmpty(message = "Category Key is required.")
    private String code;

    @Schema(description = "Category status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Category status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Category sort.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Category sort is required.")
    private Integer sort;

}