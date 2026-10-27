package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.express;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

/**
* 快递公司 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class DeliveryExpressBaseVO {

    @Schema(description = "Carrier code.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Carrier code cannot be empty.")
    private String code;

    @Schema(description = "Carrier name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotNull(message = "Carrier name cannot be empty.")
    private String name;

    @Schema(description = "Courierlogo.")
    private String logo;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    private Integer status;

}
