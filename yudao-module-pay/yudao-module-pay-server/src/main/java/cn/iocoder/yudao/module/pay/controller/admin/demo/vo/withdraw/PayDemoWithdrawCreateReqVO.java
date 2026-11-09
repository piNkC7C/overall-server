package cn.iocoder.yudao.module.pay.controller.admin.demo.vo.withdraw;

import cn.hutool.core.util.ObjectUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pay.enums.demo.PayDemoWithdrawTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Schema(description = "管理后台 - 示例提现单创建 Request VO")
@Data
public class PayDemoWithdrawCreateReqVO {

    @Schema(description = "提现标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Taro is a vegetable")
    @NotEmpty(message = "Withdrawal title is required.")
    private String subject;

    @Schema(description = "提现金额，单位：分", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Withdrawal amount is required.")
    @Min(value = 1, message = "Withdrawal amount must be greater than 0.")
    private Integer price;

    @Schema(description = "收款人账号", requiredMode= Schema.RequiredMode.REQUIRED, example = "test1")
    @NotBlank(message = "Receipt person account is required.")
    private String userAccount;

    @Schema(description = "收款人姓名", example = "test1")
    private String userName;

    @Schema(description = "提现方式", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
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
