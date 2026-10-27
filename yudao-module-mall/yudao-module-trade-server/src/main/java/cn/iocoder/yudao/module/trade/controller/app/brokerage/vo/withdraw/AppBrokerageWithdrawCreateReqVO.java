package cn.iocoder.yudao.module.trade.controller.app.brokerage.vo.withdraw;

import cn.iocoder.yudao.framework.common.util.validation.ValidationUtils;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pay.enums.PayChannelEnum;
import cn.iocoder.yudao.module.trade.enums.brokerage.BrokerageWithdrawTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import jakarta.validation.Validator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Schema(description = "Reseller withdrawal create request VO.")
@Data
public class AppBrokerageWithdrawCreateReqVO {

    @Schema(description = "Withdrawal method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(value = BrokerageWithdrawTypeEnum.class, message = "Withdrawal method must be {value}.")
    private Integer type;

    @Schema(description = "Withdrawal amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000")
    @PositiveOrZero(message = "Withdrawal amount cannot be less than 0.")
    @Min(value = 30, message = "WeChat withdrawal amount cannot be less than 0.3.", groups = {WechatApi.class})
    @NotNull(message = "Withdrawal amount is required.")
    private Integer price;

    @Schema(description = "Withdrawal account.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456789")
    @NotBlank(message = "Withdrawal account is required.", groups = {Bank.class, WechatApi.class, AlipayApi.class})
    private String userAccount;

    @Schema(description = "Withdrawal Name.", example = "John.")
    @NotBlank(message = "Withdrawal Name is required.", groups = {Bank.class, WechatApi.class, AlipayApi.class})
    private String userName;

    @Schema(description = "Payment QR image.", example = "https://www.iocoder.cn/1.png")
    @URL(message = "Payment-code image must be a URL.", groups = {WechatQR.class, AlipayQR.class})
    private String qrCodeUrl;

    @Schema(description = "Withdrawal bank.", example = "1")
    @NotNull(message = "Withdrawal bank cannot be empty.", groups = {Bank.class})
    private String bankName;
    @Schema(description = "Bank Address.", example = "Downtown branch")
    private String bankAddress;

    @Schema(description = "Transfer channel.", example = "wx_lite")
    @NotNull(message = "Transfer channel is required.", groups = {WechatApi.class})
    @InEnum(PayChannelEnum.class)
    private String transferChannelCode;

    public interface Wallet {
    }

    public interface Bank {
    }

    public interface WechatQR {
    }

    public interface WechatApi {
    }

    public interface AlipayQR {
    }

    public interface AlipayApi {
    }

    public void validate(Validator validator) {
        if (BrokerageWithdrawTypeEnum.WALLET.getType().equals(type)) {
            ValidationUtils.validate(validator, this, Wallet.class);
        } else if (BrokerageWithdrawTypeEnum.BANK.getType().equals(type)) {
            ValidationUtils.validate(validator, this, Bank.class);
        } else if (BrokerageWithdrawTypeEnum.WECHAT_QR.getType().equals(type)) {
            ValidationUtils.validate(validator, this, WechatQR.class);
        } else if (BrokerageWithdrawTypeEnum.WECHAT_API.getType().equals(type)) {
            ValidationUtils.validate(validator, this, WechatApi.class);
        } else if (BrokerageWithdrawTypeEnum.ALIPAY_QR.getType().equals(type)) {
            ValidationUtils.validate(validator, this, AlipayQR.class);
        } else if (BrokerageWithdrawTypeEnum.ALIPAY_API.getType().equals(type)) {
            ValidationUtils.validate(validator, this, AlipayApi.class);
        }
    }

}
