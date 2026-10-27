package cn.iocoder.yudao.module.mp.controller.admin.message.vo.autoreply;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - Official AccountAuto reply page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MpAutoReplyPageReqVO extends PageParam {

    @Schema(description = "Official Account account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Official Account account code is required.")
    private Long accountId;

}
