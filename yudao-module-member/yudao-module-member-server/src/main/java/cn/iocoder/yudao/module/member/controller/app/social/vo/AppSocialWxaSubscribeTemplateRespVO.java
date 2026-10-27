package cn.iocoder.yudao.module.member.controller.app.social.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Get mini program subscribe template response VO.")
@Data
public class AppSocialWxaSubscribeTemplateRespVO {

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "9Aw5ZV1j9xdWTFEkqCpZ7mIBbSC34khK55OtzUPl0rU")
    private String id;

    @Schema(description = "Template title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Order payment notification.")
    private String title;

    @Schema(description = "Template content.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "{ {result.DATA} }\\n\\nPayout amount:{ {withdrawMoney.DATA} }\\nPayout time:    { {withdrawTime.DATA} }")
    private String content;

    @Schema(description = "Template content sample.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Order time:2016Year8Month8Day.")
    private String example;

    @Schema(description = "Template type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer type; // 2 为一次性订阅，3 为长期订阅

}
