package cn.iocoder.yudao.module.product.controller.app.comment.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "User App - product review page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppCommentPageReqVO extends PageParam {

    /**
     * 好评
     */
    public static final Integer GOOD_COMMENT = 1;
    /**
     * 中评
     */
    public static final Integer MEDIOCRE_COMMENT = 2;
    /**
     * 差评
     */
    public static final Integer NEGATIVE_COMMENT = 3;

    @Schema(description = "Product SPU code.", example = "29502")
    @NotNull(message = "Product SPU code is required.")
    private Long spuId;

    @Schema(description = "App review-page tab. 0=all, 1=good, 2=average, 3=poor.", example = "0")
    @NotNull(message = "Product SPU code is required.")
    private Integer type;

}
