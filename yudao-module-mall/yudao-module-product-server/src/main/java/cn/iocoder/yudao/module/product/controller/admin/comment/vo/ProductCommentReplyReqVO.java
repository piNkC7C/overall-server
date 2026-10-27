package cn.iocoder.yudao.module.product.controller.admin.comment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Schema(description = "Merchant review-reply request VO.")
@Data
@ToString(callSuper = true)
public class ProductCommentReplyReqVO {

    @Schema(description = "Review code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15721")
    @NotNull(message = "Review code is required.")
    private Long id;

    @Schema(description = "Merchant reply.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Thank you")
    @NotEmpty(message = "Merchant reply cannot be empty.")
    private String replyContent;

}
