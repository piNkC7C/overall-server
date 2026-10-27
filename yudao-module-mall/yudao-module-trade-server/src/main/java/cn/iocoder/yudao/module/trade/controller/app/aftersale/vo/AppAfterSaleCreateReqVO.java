package cn.iocoder.yudao.module.trade.controller.app.aftersale.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.trade.enums.aftersale.AfterSaleWayEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Schema(description = "User App - trade after-sales create request.")
@Data
public class AppAfterSaleCreateReqVO {

    @Schema(description = "Order item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Order item code is required.")
    private Long orderItemId;

    @Schema(description = "After-sales method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "After-sales method is required.")
    @InEnum(value = AfterSaleWayEnum.class, message = "After-sales method must be {value}.")
    private Integer way;

    @Schema(description = "Refund amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Refund amount is required.")
    @Min(value = 1, message = "Refund amount must be greater than 0.")
    private Integer refundPrice;

    @Schema(description = "Apply please reason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Apply please reason is required.")
    private String applyReason;

    @Schema(description = "Extra description.", example = "Product quality is poor")
    private String applyDescription;

    @Schema(description = "Supporting images.", example = "https://www.iocoder.cn/1.png, https://www.iocoder.cn/2.png")
    private List<String> applyPicUrls;

}
