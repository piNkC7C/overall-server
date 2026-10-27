package cn.iocoder.yudao.module.system.api.social.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/qr-code/getUnlimitedQRCode.html">获取不限制的小程序码</a>
 */
@Schema(description = "Get get mini program QR code request VO.")
@Data
public class SocialWxQrcodeReqDTO {

    /**
     * 页面路径不能携带参数（参数请放在scene字段里）
     */
    public static final String SCENE = "";
    /**
     * 二维码宽度
     */
    public static final Integer WIDTH = 430;
    /**
     * 自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调
     */
    public static final Boolean AUTO_COLOR = true;
    /**
     * 检查 page 是否存在
     */
    public static final Boolean CHECK_PATH = true;
    /**
     * 是否需要透明底色
     *
     * hyaline 为 true 时，生成透明底色的小程序码
     */
    public static final Boolean HYALINE = true;

    @Schema(description = "Scene.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1001")
    @NotEmpty(message = "Scene cannot be empty.")
    private String scene;

    @Schema(description = "Page path.", requiredMode = Schema.RequiredMode.REQUIRED, example = "pages/goods/index")
    @NotEmpty(message = "Page path cannot be empty.")
    private String path;

    @Schema(description = "QR code width.", example = "430")
    private Integer width;

    @Schema(description = "Transparent background.", example = "true")
    private Boolean autoColor;

    @Schema(description = "Is not check page is not exists.", example = "true")
    private Boolean checkPath;

    @Schema(description = "Transparent background.", example = "true")
    private Boolean hyaline;

}
