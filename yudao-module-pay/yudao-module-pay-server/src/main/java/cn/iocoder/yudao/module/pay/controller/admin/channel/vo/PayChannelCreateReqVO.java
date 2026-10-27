package cn.iocoder.yudao.module.pay.controller.admin.channel.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - payment channel create request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayChannelCreateReqVO extends PayChannelBaseVO {

    @Schema(description = "Channel code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "alipay_pc")
    @NotNull(message = "Channel code is required.")
    private String code;

    @Schema(description = "Channelsetting json String.")
    @NotBlank(message = "Channelsetting is required.")
    private String config;

}
