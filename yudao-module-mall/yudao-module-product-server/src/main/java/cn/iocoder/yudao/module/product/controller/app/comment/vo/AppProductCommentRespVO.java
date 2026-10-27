package cn.iocoder.yudao.module.product.controller.app.comment.vo;

import cn.iocoder.yudao.module.product.controller.app.property.vo.value.AppProductPropertyValueDetailRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "User App - product review details response.")
@Data
@ToString(callSuper = true)
public class AppProductCommentRespVO {

    @Schema(description = "Review person user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15721")
    private Long userId;

    @Schema(description = "Review person name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    private String userNickname;

    @Schema(description = "Review person Avatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.png")
    private String userAvatar;

    @Schema(description = "Order item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24965")
    private Long id;

    @Schema(description = "Anonymous.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean anonymous;

    @Schema(description = "Trade order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24428")
    private Long orderId;

    @Schema(description = "Trade order item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8233")
    private Long orderItemId;

    @Schema(description = "Merchant replied.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean replyStatus;

    @Schema(description = "Reply admin code.", example = "22212")
    private Long replyUserId;

    @Schema(description = "Merchant reply.", example = "Thanks, your review keeps us going")
    private String replyContent;

    @Schema(description = "Merchant reply time.")
    private LocalDateTime replyTime;

    @Schema(description = "Follow-up review content.", example = "Still smooth after long wear")
    private String additionalContent;

    @Schema(description = "Follow-up review image URLs, comma-separated, up to 9.", example = "[https://www.iocoder.cn/xx.png, https://www.iocoder.cn/xxx.png]")
    private List<String> additionalPicUrls;

    @Schema(description = "Follow-up review time.")
    private LocalDateTime additionalTime;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "91192")
    @NotNull(message = "Product SPU code is required.")
    private Long spuId;

    @Schema(description = "Product SPU name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool smooth tee")
    @NotNull(message = "Product SPU name is required.")
    private String spuName;

    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "81192")
    @NotNull(message = "Product SKU code is required.")
    private Long skuId;

    @Schema(description = "Product SKU attribute.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<AppProductPropertyValueDetailRespVO> skuProperties;

    @Schema(description = "Star rating (1-5).", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Star rating (1-5) cannot be empty.")
    private Integer scores;

    @Schema(description = "Description rating (1-5).", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Description rating (1-5) cannot be empty.")
    private Integer descriptionScores;

    @Schema(description = "Service rating (1-5).", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Service rating (1-5) cannot be empty.")
    private Integer benefitScores;

    @Schema(description = "Comment content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Wow, it is really smooth and cool. Great review.")
    @NotNull(message = "Comment content is required.")
    private String content;

    @Schema(description = "Review image URLs, comma-separated, up to 9.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "[https://www.iocoder.cn/xx.png]")
    @Size(max = 9, message = "Review image count cannot exceed 9 images.")
    private List<String> picUrls;

}
