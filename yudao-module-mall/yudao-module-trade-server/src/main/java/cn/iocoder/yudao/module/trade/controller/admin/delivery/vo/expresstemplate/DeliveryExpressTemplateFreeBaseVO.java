package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.expresstemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * 快递运费模板包邮 Base VO，提供给添加运费模板使用
 */
@Data
public class DeliveryExpressTemplateFreeBaseVO {

    @Schema(description = "Region code list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1,120000]")
    @NotEmpty(message = "Region code list is required.")
    private List<Integer> areaIds;

    @Schema(description = "Free-shipping amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5000")
    @NotNull(message = "Free-shipping amount cannot be empty.")
    private Integer freePrice;

    @Schema(description = "Pieces for free shipping.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Pieces for free shipping cannot be empty.")
    private Integer freeCount;

}
