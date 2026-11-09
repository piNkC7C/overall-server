package cn.iocoder.yudao.module.member.controller.app.social.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "用户 APP - 获得小程序订阅模版 Response VO")
@Data
public class AppSocialWxaSubscribeTemplateRespVO {

    @Schema(description = "模版编号", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "9Aw5ZV1j9xdWTFEkqCpZ7mIBbSC34khK55OtzUPl0rU")
    private String id;

    @Schema(description = "模版标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Order payment notification.")
    private String title;

    @Schema(description = "模版内容", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "{ {result.DATA} }\\n\\nPayout amount:{ {withdrawMoney.DATA} }\\nPayout time:    { {withdrawTime.DATA} }")
    private String content;

    @Schema(description = "模板内容示例", requiredMode = Schema.RequiredMode.REQUIRED, example = "Order time:2016Year8Month8Day.")
    private String example;

    @Schema(description = "模版类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer type; // 2 为一次性订阅，3 为长期订阅

}
