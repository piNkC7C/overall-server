package cn.iocoder.yudao.module.mp.controller.admin.message.vo.autoreply;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - Official AccountAuto reply create request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MpAutoReplyCreateReqVO extends MpAutoReplyBaseVO {

    @Schema(description = "Official Account account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Official Account account code is required.")
    private Long accountId;

}
