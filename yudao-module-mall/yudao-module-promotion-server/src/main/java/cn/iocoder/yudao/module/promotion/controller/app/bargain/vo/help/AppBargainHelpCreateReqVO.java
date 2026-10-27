package cn.iocoder.yudao.module.promotion.controller.app.bargain.vo.help;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "User App - bargain assist create request.")
@Data
public class AppBargainHelpCreateReqVO {

    @Schema(description = "Bargain record code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Bargain record code is required.")
    private Long recordId;

}
