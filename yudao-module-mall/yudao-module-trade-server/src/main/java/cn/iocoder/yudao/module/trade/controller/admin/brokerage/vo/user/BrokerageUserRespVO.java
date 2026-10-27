package cn.iocoder.yudao.module.trade.controller.admin.brokerage.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - distributor response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BrokerageUserRespVO extends BrokerageUserBaseVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20019")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    // ========== user info ==========

    @Schema(description = "UserAvatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xxx.png")
    private String avatar;
    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    private String nickname;

    // ========== 推广信息 ========== 注意：是包括 1 + 2 级的数据

    @Schema(description = "Referred user count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20019")
    private Integer brokerageUserCount;
    @Schema(description = "Promo Orders.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20019")
    private Integer brokerageOrderCount;
    @Schema(description = "Referral order amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20019")
    private Integer brokerageOrderPrice;

    // ========== withdrawal info ==========

    @Schema(description = "Already withdrawal amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20019")
    private Integer withdrawPrice;
    @Schema(description = "Withdraw count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20019")
    private Integer withdrawCount;

}
