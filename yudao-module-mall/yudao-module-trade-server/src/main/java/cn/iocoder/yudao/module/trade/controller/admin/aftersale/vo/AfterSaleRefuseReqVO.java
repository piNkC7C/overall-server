package cn.iocoder.yudao.module.trade.controller.admin.aftersale.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - trade after-sales Reject receiving request.")
@Data
public class AfterSaleRefuseReqVO {

    @Schema(description = "After-sales code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "After-sales code is required.")
    private Long id;

    @Schema(description = "Receiving notes.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Example.")
    @NotNull(message = "Receiving notes is required.")
    private String refuseMemo;

}
