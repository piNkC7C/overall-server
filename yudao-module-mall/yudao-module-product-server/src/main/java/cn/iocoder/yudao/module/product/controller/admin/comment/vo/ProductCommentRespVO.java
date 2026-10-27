package cn.iocoder.yudao.module.product.controller.admin.comment.vo;

import cn.iocoder.yudao.module.product.controller.admin.spu.vo.ProductSkuSaveReqVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - product review response.")
@Data
public class ProductCommentRespVO {

    @Schema(description = "Order item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24965")
    private Long id;

    @Schema(description = "Review person.", requiredMode = Schema.RequiredMode.REQUIRED, example = "16868")
    private Long userId;

    @Schema(description = "Review person name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Miss")
    private String userNickname;

    @Schema(description = "Review person Avatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.png")
    private String userAvatar;
    @Schema(description = "Anonymous.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean anonymous;

    @Schema(description = "Trade order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24428")
    private Long orderId;

    @Schema(description = "Review order item.", requiredMode = Schema.RequiredMode.REQUIRED, example = "19292")
    private Long orderItemId;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool smooth breathable tee")
    private Long spuId;

    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long skuId;

    @Schema(description = "Product SPU name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    private String spuName;

    @Schema(description = "Product SKU ImageAddress.", example = "https://www.iocoder.cn/yudao.jpg")
    private String skuPicUrl;

    @Schema(description = "Product SKU spec values.")
    private List<ProductSkuSaveReqVO.Property> skuProperties;

    @Schema(description = "Visible", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean visible;

    @Schema(description = "Star rating (1-5).", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Integer scores;

    @Schema(description = "Description rating (1-5).", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Integer descriptionScores;

    @Schema(description = "Service rating (1-5).", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Integer benefitScores;

    @Schema(description = "Comment content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Feels smooth and cool to wear")
    private String content;

    @Schema(description = "Review image URLs, comma-separated, up to 9.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[https://www.iocoder.cn/xx.png]")
    private List<String> picUrls;

    @Schema(description = "Merchant replied.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean replyStatus;

    @Schema(description = "Reply admin code.", example = "9527")
    private Long replyUserId;

    @Schema(description = "Merchant reply.", example = "Thanks for the kind review")
    private String replyContent;

    @Schema(description = "Merchant reply time.", example = "2023-08-08 12:20:55")
    private LocalDateTime replyTime;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
