package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.expresstemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * 快递运费模板运费设置 Base VO，提供给添加运费模板使用
 */
@Data
public class DeliveryExpressTemplateChargeBaseVO {

    @Schema(description = "Code.", example = "6592", hidden = true) // 由于想简单一点，复用这个 VO 在更新操作，所以 hidden 为 false
    private Long id;

    @Schema(description = "Region code list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1,120000]")
    @NotEmpty(message = "Region code list is required.")
    private List<Integer> areaIds;

    @Schema(description = "First-piece quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "First-piece quantity cannot be empty.")
    private Double startCount;

    @Schema(description = "Base price.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000")
    @NotNull(message = "Base price cannot be empty.")
    private Integer startPrice;

    @Schema(description = "Additional-piece quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Additional-piece quantity cannot be empty.")
    private Double extraCount;

    @Schema(description = "Surcharge.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2000")
    @NotNull(message = "Surcharge cannot be empty.")
    private Integer extraPrice;
}
