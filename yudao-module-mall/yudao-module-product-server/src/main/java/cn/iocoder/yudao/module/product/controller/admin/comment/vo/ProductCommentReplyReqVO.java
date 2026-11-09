package cn.iocoder.yudao.module.product.controller.admin.comment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Schema(description = "管理后台 - 商品评价的商家回复 Request VO")
@Data
@ToString(callSuper = true)
public class ProductCommentReplyReqVO {

    @Schema(description = "评价编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "15721")
    @NotNull(message = "Review code is required.")
    private Long id;

    @Schema(description = "商家回复内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "Thank you")
    @NotEmpty(message = "Merchant reply cannot be empty.")
    private String replyContent;

}
