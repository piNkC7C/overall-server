package cn.iocoder.yudao.module.oa.controller.admin.discussion.vo.vote;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - OA Poll optionscreate/update request.")
@Data
public class OaVoteOptionSaveReqVO {

    @Schema(description = "Option title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Friday afternoon")
    @NotBlank(message = "Poll option title cannot be empty.")
    @Size(max = 200, message = "Poll option title cannot exceed 200 characters.")
    private String title;

    @Schema(description = "Option color.", example = "#409EFF")
    @Size(max = 20, message = "Poll option color cannot exceed 20 characters.")
    private String color;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Sort is required.")
    private Integer sort;

}
