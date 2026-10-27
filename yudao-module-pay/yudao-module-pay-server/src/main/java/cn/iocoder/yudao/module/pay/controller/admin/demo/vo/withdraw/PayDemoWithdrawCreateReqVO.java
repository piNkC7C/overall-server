package cn.iocoder.yudao.module.pay.controller.admin.demo.vo.withdraw;

import cn.hutool.core.util.ObjectUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pay.enums.demo.PayDemoWithdrawTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Schema(description = "Admin - sample withdrawal order create request.")
@Data
public class PayDemoWithdrawCreateReqVO {

    @Schema(description = "Withdrawal title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Taro is a vegetable")
    @NotEmpty(message = "Withdrawal title is required.")
    private String subject;

    @Schema(description = "Withdrawal amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Withdrawal amount is required.")
    @Min(value = 1, message = "Withdrawal amount must be greater than 0.")
    private Integer price;

    @Schema(description = "Receipt person account.", requiredMode= Schema.RequiredMode.REQUIRED, example = "test1")
    @NotBlank(message = "Receipt person account is required.")
    private String userAccount;

    @Schema(description = "Receipt person Name.", example = "test1")
    private String userName;

    @Schema(description = "Withdrawal method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Withdrawal method is required.")
    @InEnum(PayDemoWithdrawTypeEnum.class)
    private Integer type;

    @AssertTrue(message = "Receipt person Name.")
    public boolean isUserNameValid() {
        // 特殊：支付宝必须填写用户名！！！
        return ObjectUtil.notEqual(type, PayDemoWithdrawTypeEnum.ALIPAY.getType())
                || ObjectUtil.isNotEmpty(userName);
    }

}
