package cn.iocoder.yudao.module.mp.controller.admin.account.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

/**
 * 公众号账号 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 *
 * @author fengdan
 */
@Data
public class MpAccountBaseVO {

    @Schema(description = "公众号名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotEmpty(message = "Official Account name is required.")
    private String name;

    @Schema(description = "公众号微信号", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudaoyuanma")
    @NotEmpty(message = "Official AccountWeChat no. is required.")
    private String account;

    @Schema(description = "公众号 appId", requiredMode = Schema.RequiredMode.REQUIRED, example = "wx5b23ba7a5589ecbb")
    @NotEmpty(message = "Official Account appId is required.")
    private String appId;

    @Schema(description = "公众号密钥", requiredMode = Schema.RequiredMode.REQUIRED, example = "3a7b3b20c537e52e74afd395eb85f61f")
    @NotEmpty(message = "Official Account secret is required.")
    private String appSecret;

    @Schema(description = "公众号 token", requiredMode = Schema.RequiredMode.REQUIRED, example = "kangdayuzhen")
    @NotEmpty(message = "Official Account token is required.")
    private String token;

    @Schema(description = "加密密钥", example = "gjN+Ksei")
    private String aesKey;

    @Schema(description = "备注", example = "Follow Yudao and keep learning")
    private String remark;

}
