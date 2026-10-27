package cn.iocoder.yudao.module.trade.controller.admin.brokerage.vo.withdraw;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Commission withdrawal response VO.")
@Data
public class BrokerageWithdrawRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7161")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11436")
    private Long userId;

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String userNickname;

    @Schema(description = "Withdrawal amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "18781")
    private Integer price;

    @Schema(description = "Withdraw fee.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11417")
    private Integer feePrice;

    @Schema(description = "Current total commission.", requiredMode = Schema.RequiredMode.REQUIRED, example = "18576")
    private Integer totalPrice;

    @Schema(description = "Withdrawal type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Legal name.", example = "Sam.")
    private String userName;

    @Schema(description = "Receipt account.", example = "88677912132")
    private String userAccount;

    @Schema(description = "Bank name", example = "1")
    private String bankName;

    @Schema(description = "Bank Address.", example = "Downtown branch")
    private String bankAddress;

    @Schema(description = "Payment QR code.", example = "https://www.iocoder.cn")
    private String qrCodeUrl;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Rejection reason.", example = "Not for.")
    private String auditReason;

    @Schema(description = "Approval time.")
    private LocalDateTime auditTime;

    @Schema(description = "Notes.", example = "Sample.")
    private String remark;

    @Schema(description = "Transfer order code.", example = "1024")
    private Long payTransferId;

    @Schema(description = "Transfer ErrorTip.", example = "Balance is insufficient.")
    private String transferErrorMsg;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
