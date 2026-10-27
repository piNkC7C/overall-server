package cn.iocoder.yudao.module.pay.controller.admin.wallet.vo.wallet;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - userwallet response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayWalletRespVO extends PayWalletBaseVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "29528")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
