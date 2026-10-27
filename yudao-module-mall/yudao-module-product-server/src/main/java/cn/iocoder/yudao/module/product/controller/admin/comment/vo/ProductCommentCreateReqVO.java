package cn.iocoder.yudao.module.product.controller.admin.comment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - product review create request.")
@Data
public class ProductCommentCreateReqVO {

    @Schema(description = "Review person name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Miss")
    @NotNull(message = "Review person name is required.")
    private String userNickname;

    @Schema(description = "Review person Avatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.png")
    @NotNull(message = "Review person Avatar is required.")
    private String userAvatar;

    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Product SKU code is required.")
    private Long skuId;

    @Schema(description = "Description rating (1-5).", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Description rating cannot be empty.")
    private Integer descriptionScores;

    @Schema(description = "Service rating (1-5).", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Service rating cannot be empty.")
    private Integer benefitScores;

    @Schema(description = "Comment content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Feels smooth and cool to wear")
    @NotNull(message = "Comment content is required.")
    private String content;

    @Schema(description = "Review image URLs, comma-separated, up to 9.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "[https://www.iocoder.cn/xx.png]")
    @Size(max = 9, message = "Review image count cannot exceed 9 images.")
    private List<String> picUrls;

}
