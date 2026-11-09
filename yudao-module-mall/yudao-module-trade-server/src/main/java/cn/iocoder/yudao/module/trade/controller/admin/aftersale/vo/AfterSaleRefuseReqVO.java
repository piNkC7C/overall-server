package cn.iocoder.yudao.module.trade.controller.admin.aftersale.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "管理后台 - 交易售后拒绝收货 Request VO")
@Data
public class AfterSaleRefuseReqVO {

    @Schema(description = "售后编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "After-sales code is required.")
    private Long id;

    @Schema(description = "收货备注", requiredMode = Schema.RequiredMode.REQUIRED, example = "Example.")
    @NotNull(message = "Receiving notes is required.")
    private String refuseMemo;

}
