package cn.iocoder.yudao.module.promotion.controller.app.banner.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "用户 App - Banner Response VO")
@Data
public class AppBannerRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Title is required.")
    private String title;

    @Schema(description = "跳转链接", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Link is required.")
    private String url;

    @Schema(description = "图片地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "ImageAddress is required.")
    private String picUrl;

}
