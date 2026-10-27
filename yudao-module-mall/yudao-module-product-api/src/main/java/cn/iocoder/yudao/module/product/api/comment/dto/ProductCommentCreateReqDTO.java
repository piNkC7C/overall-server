package cn.iocoder.yudao.module.product.api.comment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.util.List;

@Schema(description = "RPC service - product comment create Request DTO.")
@Data
public class ProductCommentCreateReqDTO {

    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Product SKU code is required.")
    private Long skuId;
    @Schema(description = "Order code.", example = "223")
    private Long orderId;
    @Schema(description = "Trade order item code.", example = "666")
    private Long orderItemId;

    @Schema(description = "Description rating (1-5).", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Description rating cannot be empty.")
    private Integer descriptionScores;
    @Schema(description = "Service rating (1-5).", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Service rating cannot be empty.")
    private Integer benefitScores;
    @Schema(description = "Comment content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Positive review")
    @NotNull(message = "Comment content is required.")
    private String content;
    @Schema(description = "Review image URLs, comma-separated, up to 9.", example = "https://www.iocoder.cn/xxx.jpg,http://www.iocoder.cn/yyy.jpg")
    private List<String> picUrls;

    @Schema(description = "Anonymous.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Anonymous cannot be empty.")
    private Boolean anonymous;
    @Schema(description = "Review person.", requiredMode = Schema.RequiredMode.REQUIRED, example = "888")
    @NotNull(message = "Review person is required.")
    private Long userId;

}
