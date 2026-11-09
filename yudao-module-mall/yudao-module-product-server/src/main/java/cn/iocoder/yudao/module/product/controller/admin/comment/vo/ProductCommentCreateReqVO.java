package cn.iocoder.yudao.module.product.controller.admin.comment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - 商品评价创建 Request VO")
@Data
public class ProductCommentCreateReqVO {

    @Schema(description = "评价人名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Miss")
    @NotNull(message = "Review person name is required.")
    private String userNickname;

    @Schema(description = "评价人头像", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.png")
    @NotNull(message = "Review person Avatar is required.")
    private String userAvatar;

    @Schema(description = "商品 SKU 编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Product SKU code is required.")
    private Long skuId;

    @Schema(description = "描述星级 1-5 分", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Description rating cannot be empty.")
    private Integer descriptionScores;

    @Schema(description = "服务星级 1-5 分", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Service rating cannot be empty.")
    private Integer benefitScores;

    @Schema(description = "评论内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "Feels smooth and cool to wear")
    @NotNull(message = "Comment content is required.")
    private String content;

    @Schema(description = "评论图片地址数组，以逗号分隔最多上传 9 张", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "[https://www.iocoder.cn/xx.png]")
    @Size(max = 9, message = "Review image count cannot exceed 9 images.")
    private List<String> picUrls;

}
