package cn.iocoder.yudao.module.promotion.controller.app.bargain.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "User App - bargain record create request.")
@Data
public class AppBargainRecordCreateReqVO {

    @Schema(description = "Bargain campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Bargain campaign code is required.")
    private Long activityId;

}
