package cn.iocoder.yudao.module.oa.controller.admin.discussion.vo.vote;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - OA 投票选项新增/修改 Request VO")
@Data
public class OaVoteOptionSaveReqVO {

    @Schema(description = "选项标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Friday afternoon")
    @NotBlank(message = "Poll option title cannot be empty.")
    @Size(max = 200, message = "Poll option title cannot exceed 200 characters.")
    private String title;

    @Schema(description = "选项颜色", example = "#409EFF")
    @Size(max = 20, message = "Poll option color cannot exceed 20 characters.")
    private String color;

    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Sort is required.")
    private Integer sort;

}
