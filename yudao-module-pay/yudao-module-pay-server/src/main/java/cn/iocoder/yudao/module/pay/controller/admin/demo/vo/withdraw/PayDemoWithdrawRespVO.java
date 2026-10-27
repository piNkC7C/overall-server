package cn.iocoder.yudao.module.pay.controller.admin.demo.vo.withdraw;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - sample transfer order create request.")
@Data
public class PayDemoWithdrawRespVO {

    @Schema(description = "Transfer order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Withdrawal title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Meal expense")
    private String subject;

    @Schema(description = "Withdrawal amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "22338")
    private Integer price;

    @Schema(description = "Receipt person Name.",  example = "test")
    private String userName;

    @Schema(description = "Receipt person account.", example = "32167")
    private String userAccount;

    @Schema(description = "Withdrawal type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Withdrawal status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer status;

    // ========== 转账相关字段 ==========

    @Schema(description = "Transfer order code.", example = "23695")
    private Long payTransferId;

    @Schema(description = "Transfer channel.", example = "wx_lite")
    private String transferChannelCode;

    @Schema(description = "Transfer succeeded time.")
    private LocalDateTime transferTime;

    @Schema(description = "Transfer failedreason.", example = "IP is invalid.")
    private String transferErrorMsg;

}
