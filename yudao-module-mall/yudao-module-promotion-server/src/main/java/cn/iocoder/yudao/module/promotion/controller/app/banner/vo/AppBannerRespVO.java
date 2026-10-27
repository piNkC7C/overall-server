package cn.iocoder.yudao.module.promotion.controller.app.banner.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "User App - Banner response.")
@Data
public class AppBannerRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Title is required.")
    private String title;

    @Schema(description = "Link", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Link is required.")
    private String url;

    @Schema(description = "ImageAddress.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "ImageAddress is required.")
    private String picUrl;

}
