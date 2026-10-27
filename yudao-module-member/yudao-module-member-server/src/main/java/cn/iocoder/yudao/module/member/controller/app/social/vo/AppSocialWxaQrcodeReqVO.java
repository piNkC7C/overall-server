package cn.iocoder.yudao.module.member.controller.app.social.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Schema(description = "Get get mini program QR code request VO.")
@Data
public class AppSocialWxaQrcodeReqVO {

    /**
     * 页面路径不能携带参数（参数请放在scene字段里）
     */
    @Schema(description = "SceneValue.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1001")
    private String scene;

    /**
     * 默认是主页，页面 page，例如 pages/index/index，根路径前不要填加 /，不能携带参数（参数请放在scene字段里），
     * 如果不填写这个字段，默认跳主页面。scancode_time为系统保留参数，不允许配置
     */
    @Schema(description = "Page path.", requiredMode = Schema.RequiredMode.REQUIRED, example = "pages/goods/index")
    @NotEmpty(message = "Page path cannot be empty.")
    private String path;

    @Schema(description = "QR code width.", requiredMode = Schema.RequiredMode.REQUIRED, example = "430")
    private Integer width;

    @Schema(description = "Whether to auto-set the line color.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean autoColor;

    @Schema(description = "Is / not check page is not exists.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean checkPath;

    @Schema(description = "Whether a transparent background is required.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean hyaline;

}
