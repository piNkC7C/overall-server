package cn.iocoder.yudao.module.pay.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - payment response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayOrderRespVO extends PayOrderBaseVO {

    @Schema(description = "Payment code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
