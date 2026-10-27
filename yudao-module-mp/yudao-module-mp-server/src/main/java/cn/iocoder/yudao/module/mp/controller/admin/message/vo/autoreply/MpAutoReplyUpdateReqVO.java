package cn.iocoder.yudao.module.mp.controller.admin.message.vo.autoreply;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - Official AccountAuto reply update request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MpAutoReplyUpdateReqVO extends MpAutoReplyBaseVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Primary key is required.")
    private Long id;

}
