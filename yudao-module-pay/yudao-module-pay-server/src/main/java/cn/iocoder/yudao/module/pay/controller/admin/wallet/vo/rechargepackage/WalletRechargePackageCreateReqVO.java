package cn.iocoder.yudao.module.pay.controller.admin.wallet.vo.rechargepackage;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Top-up plan create request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WalletRechargePackageCreateReqVO extends WalletRechargePackageBaseVO {

}
