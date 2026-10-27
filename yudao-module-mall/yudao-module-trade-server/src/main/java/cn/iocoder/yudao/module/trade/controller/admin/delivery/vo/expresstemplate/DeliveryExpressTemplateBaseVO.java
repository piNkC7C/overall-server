package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.expresstemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

/**
* 快递运费模板 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class DeliveryExpressTemplateBaseVO {

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    @NotNull(message = "Template name is required.")
    private String name;

    @Schema(description = "Shipping billing method: 1 piece, 2 weight, 3 volume.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Shipping billing method: 1 piece, 2 weight, 3 volume cannot be empty.")
    private Integer chargeMode;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Sort is required.")
    private Integer sort;

}
