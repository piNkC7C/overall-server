package cn.iocoder.yudao.module.trade.controller.app.brokerage.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "App App - bind Promoter request.")
@Data
public class AppBrokerageUserBindReqVO {

    @Schema(description = "Promoter code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Promoter code is required.")
    private Long bindUserId;

}
