package cn.iocoder.yudao.module.trade.controller.app.order.vo.item;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Schema(description = "User App - product review create request.")
@Data
public class AppTradeOrderItemCommentCreateReqVO {

    @Schema(description = "Anonymous.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Anonymous cannot be empty.")
    private Boolean anonymous;

    @Schema(description = "Trade order item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2312312")
    @NotNull(message = "Trade order item code is required.")
    private Long orderItemId;

    @Schema(description = "Description rating (1-5).", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Description rating (1-5) cannot be empty.")
    private Integer descriptionScores;

    @Schema(description = "Service rating (1-5).", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Service rating (1-5) cannot be empty.")
    private Integer benefitScores;

    @Schema(description = "Comment content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Looks great on")
    @NotNull(message = "Comment content is required.")
    private String content;

    @Schema(description = "Review image URLs, comma-separated, up to 9.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[https://www.iocoder.cn/xx.png]")
    @Size(max = 9, message = "Review image count cannot exceed 9 images.")
    private List<String> picUrls;

}
