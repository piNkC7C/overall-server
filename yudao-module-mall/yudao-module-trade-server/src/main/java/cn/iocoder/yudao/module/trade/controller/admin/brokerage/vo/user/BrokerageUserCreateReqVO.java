package cn.iocoder.yudao.module.trade.controller.admin.brokerage.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - distributorcreate request.")
@Data
public class BrokerageUserCreateReqVO {

    @Schema(description = "Distributor user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Distributor user ID cannot be empty.")
    private Long userId;

    @Schema(description = "Promoter code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4587")
    @NotNull(message = "Promoter code is required.")
    private Long bindUserId;

}
