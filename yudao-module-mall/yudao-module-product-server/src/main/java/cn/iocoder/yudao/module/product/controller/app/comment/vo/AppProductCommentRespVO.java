package cn.iocoder.yudao.module.product.controller.app.comment.vo;

import cn.iocoder.yudao.module.product.controller.app.property.vo.value.AppProductPropertyValueDetailRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "用户 App - 商品评价详情 Response VO")
@Data
@ToString(callSuper = true)
public class AppProductCommentRespVO {

    @Schema(description = "评价人的用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "15721")
    private Long userId;

    @Schema(description = "评价人名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    private String userNickname;

    @Schema(description = "评价人头像", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.png")
    private String userAvatar;

    @Schema(description = "订单项编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "24965")
    private Long id;

    @Schema(description = "是否匿名", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean anonymous;

    @Schema(description = "交易订单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "24428")
    private Long orderId;

    @Schema(description = "交易订单项编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "8233")
    private Long orderItemId;

    @Schema(description = "商家是否回复", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean replyStatus;

    @Schema(description = "回复管理员编号", example = "22212")
    private Long replyUserId;

    @Schema(description = "商家回复内容", example = "Thanks, your review keeps us going")
    private String replyContent;

    @Schema(description = "商家回复时间")
    private LocalDateTime replyTime;

    @Schema(description = "追加评价内容", example = "Still smooth after long wear")
    private String additionalContent;

    @Schema(description = "追评评价图片地址数组，以逗号分隔最多上传 9 张", example = "[https://www.iocoder.cn/xx.png, https://www.iocoder.cn/xxx.png]")
    private List<String> additionalPicUrls;

    @Schema(description = "追加评价时间")
    private LocalDateTime additionalTime;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "商品 SPU 编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "91192")
    @NotNull(message = "Product SPU code is required.")
    private Long spuId;

    @Schema(description = "商品 SPU 名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool smooth tee")
    @NotNull(message = "Product SPU name is required.")
    private String spuName;

    @Schema(description = "商品 SKU 编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "81192")
    @NotNull(message = "Product SKU code is required.")
    private Long skuId;

    @Schema(description = "商品 SKU 属性", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<AppProductPropertyValueDetailRespVO> skuProperties;

    @Schema(description = "评分星级 1-5 分", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Star rating (1-5) cannot be empty.")
    private Integer scores;

    @Schema(description = "描述星级 1-5 分", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Description rating (1-5) cannot be empty.")
    private Integer descriptionScores;

    @Schema(description = "服务星级 1-5 分", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Service rating (1-5) cannot be empty.")
    private Integer benefitScores;

    @Schema(description = "评论内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "Wow, it is really smooth and cool. Great review.")
    @NotNull(message = "Comment content is required.")
    private String content;

    @Schema(description = "评论图片地址数组，以逗号分隔最多上传 9 张", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "[https://www.iocoder.cn/xx.png]")
    @Size(max = 9, message = "Review image count cannot exceed 9 images.")
    private List<String> picUrls;

}
