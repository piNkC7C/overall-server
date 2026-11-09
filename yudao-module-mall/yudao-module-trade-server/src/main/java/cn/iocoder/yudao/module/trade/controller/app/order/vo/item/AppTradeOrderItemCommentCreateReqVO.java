package cn.iocoder.yudao.module.trade.controller.app.order.vo.item;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Schema(description = "用户 App - 商品评价创建 Request VO")
@Data
public class AppTradeOrderItemCommentCreateReqVO {

    @Schema(description = "是否匿名", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Anonymous cannot be empty.")
    private Boolean anonymous;

    @Schema(description = "交易订单项编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2312312")
    @NotNull(message = "Trade order item code is required.")
    private Long orderItemId;

    @Schema(description = "描述星级 1-5 分", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Description rating (1-5) cannot be empty.")
    private Integer descriptionScores;

    @Schema(description = "服务星级 1-5 分", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Service rating (1-5) cannot be empty.")
    private Integer benefitScores;

    @Schema(description = "评论内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "Looks great on")
    @NotNull(message = "Comment content is required.")
    private String content;

    @Schema(description = "评论图片地址数组，以逗号分隔最多上传 9 张", requiredMode = Schema.RequiredMode.REQUIRED, example = "[https://www.iocoder.cn/xx.png]")
    @Size(max = 9, message = "Review image count cannot exceed 9 images.")
    private List<String> picUrls;

}
