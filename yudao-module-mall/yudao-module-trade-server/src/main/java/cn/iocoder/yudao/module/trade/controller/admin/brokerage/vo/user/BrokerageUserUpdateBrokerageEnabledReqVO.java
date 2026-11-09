package cn.iocoder.yudao.module.trade.controller.admin.brokerage.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Schema(description = "管理后台 - 分销用户 - 修改推广员 Request VO")
@Data
@ToString(callSuper = true)
public class BrokerageUserUpdateBrokerageEnabledReqVO {

    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "20019")
    @NotNull(message = "User ID is required.")
    private Long id;

    @Schema(description = "推广资格", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Promo Eligibility is required.")
    private Boolean enabled;

}
