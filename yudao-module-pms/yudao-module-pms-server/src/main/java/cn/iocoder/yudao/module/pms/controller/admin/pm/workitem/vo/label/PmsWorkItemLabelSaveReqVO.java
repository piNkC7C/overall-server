package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.label;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - PMS work item tag create / edit request.")
@Data
public class PmsWorkItemLabelSaveReqVO {

    @Schema(description = "Tag code.", example = "1024")
    private Long id;

    @Schema(description = "Tag name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Urgent")
    @NotBlank(message = "Tag name is required.")
    @Size(max = 50, message = "Tag name cannot exceed 50 characters.")
    private String name;

    @Schema(description = "Tag color.", requiredMode = Schema.RequiredMode.REQUIRED, example = "#409EFF")
    @NotBlank(message = "Tag color is required.")
    @Size(max = 20, message = "Tag color cannot exceed 20 characters.")
    private String color;

}
