package cn.iocoder.yudao.module.pay.controller.admin.demo.vo.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - sample ordercreate request.")
@Data
public class PayDemoOrderCreateReqVO {

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "17682")
    @NotNull(message = "Product code is required.")
    private Long spuId;

}
