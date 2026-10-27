package cn.iocoder.yudao.module.pay.controller.admin.wallet.vo.transaction;

import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - wallet transactionpage request.")
@Data
public class PayWalletTransactionPageReqVO extends PageParam  {

    @Schema(description = "Wallet code.", example = "888")
    private Long walletId;

    @Schema(description = "User ID.", example = "1024")
    private Long userId;

    @Schema(description = "User type.", example = "1")
    @InEnum(UserTypeEnum.class)
    private Integer userType;

}
