package cn.iocoder.yudao.module.trade.controller.app.brokerage.vo.withdraw;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Reseller withdrawal response VO.")
@Data
public class AppBrokerageWithdrawRespVO {

    @Schema(description = "Withdrawal code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long id;

    @Schema(description = "Withdrawal type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Withdraw type name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WeChat")
    private String typeName;

    @Schema(description = "Withdrawal status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer status;

    @Schema(description = "Withdraw status name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Approval.")
    private String statusName;

    @Schema(description = "Withdrawal amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000")
    private Integer price;

    @Schema(description = "Withdrawal time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    // ========== 微信转账专属 ==========

    @Schema(description = "Transfer order code.", example = "1024")
    private Long payTransferId;

    @Schema(description = "Channel package info.")
    private String transferChannelPackageInfo;

    @Schema(description = "Channel merchant no.")
    private String transferChannelMchId;

}
