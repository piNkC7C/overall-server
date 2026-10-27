package cn.iocoder.yudao.module.product.controller.admin.comment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Schema(description = "Update review visibility request VO.")
@Data
@ToString(callSuper = true)
public class ProductCommentUpdateVisibleReqVO {

    @Schema(description = "Review code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15721")
    @NotNull(message = "Review code is required.")
    private Long id;

    @Schema(description = "Visible", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Visible is required.")
    private Boolean visible;

}
