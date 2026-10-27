package cn.iocoder.yudao.module.pay.controller.admin.channel.vo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import jakarta.validation.constraints.*;

@Schema(description = "Admin - payment channel update request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayChannelUpdateReqVO extends PayChannelBaseVO {

    @Schema(description = "Merchant number.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Merchant number cannot be empty.")
    private Long id;

    @Schema(description = "Channelsetting jsonString.")
    @NotBlank(message = "Channelsetting is required.")
    private String config;

}
