package cn.iocoder.yudao.module.oa.controller.admin.note.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - OA Note directory create / edit request.")
@Data
public class OaNoteCategorySaveReqVO {

    @Schema(description = "Directory code.", example = "1024")
    private Long id;

    @Schema(description = "Directory name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Work")
    @NotBlank(message = "Directory name is required.")
    @Size(max = 255, message = "Directory name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Sort is required.")
    private Integer sort;

}
