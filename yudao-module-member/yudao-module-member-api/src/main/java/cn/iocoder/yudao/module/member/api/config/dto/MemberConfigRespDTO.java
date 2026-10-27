package cn.iocoder.yudao.module.member.api.config.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "RPC service - user info Response DTO.")
@Data
public class MemberConfigRespDTO {

    @Schema(description = "Points redemption enabled.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean pointTradeDeductEnable;

    @Schema(description = "Points offset, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer pointTradeDeductUnitPrice; // 1 积分抵扣多少分

    @Schema(description = "Maximum points offset.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    private Integer pointTradeDeductMaxPrice;

    @Schema(description = "Points granted per $1.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer pointTradeGivePoint;

}
