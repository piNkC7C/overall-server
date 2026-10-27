package cn.iocoder.yudao.module.product.controller.admin.comment.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.product.enums.comment.ProductCommentScoresEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - product review page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductCommentPageReqVO extends PageParam {

    @Schema(description = "Review person name.", example = "John Doe")
    private String userNickname;

    @Schema(description = "Trade order code.", example = "24428")
    private Long orderId;

    @Schema(description = "ProductSPU code.", example = "29502")
    private Long spuId;

    @Schema(description = "ProductSPU name.", example = "Cold medicine")
    private String spuName;

    @Schema(description = "Star rating (1-5).", example = "5")
    @InEnum(ProductCommentScoresEnum.class)
    private Integer scores;

    @Schema(description = "Merchant replied.", example = "true")
    private Boolean replyStatus;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
