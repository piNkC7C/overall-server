package cn.iocoder.yudao.module.member.controller.admin.config.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

/**
 * 会员配置 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class MemberConfigBaseVO {

    @Schema(description = "Points redemption enabled.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Points-offset enabled cannot be empty.")
    private Boolean pointTradeDeductEnable;

    @Schema(description = "Points offset, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13506")
    @NotNull(message = "Points offset cannot be empty.")
    private Integer pointTradeDeductUnitPrice;

    @Schema(description = "Maximum points offset.", requiredMode = Schema.RequiredMode.REQUIRED, example = "32428")
    @NotNull(message = "Maximum points offset cannot be empty.")
    private Integer pointTradeDeductMaxPrice;

    @Schema(description = "Points granted per $1.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Points granted per 1 yuan cannot be empty.")
    private Integer pointTradeGivePoint;

}
