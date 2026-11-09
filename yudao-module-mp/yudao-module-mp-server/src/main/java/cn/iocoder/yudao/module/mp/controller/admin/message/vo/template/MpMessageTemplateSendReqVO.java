package cn.iocoder.yudao.module.mp.controller.admin.message.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Map;

@Schema(description = "管理后台 - 公众号消息模版发送 Request VO") // Relation https://developers.weixin.qq.com/doc/service/api/notify/template/api_sendtemplatemessage.html document
@Data
public class MpMessageTemplateSendReqVO {

    @Schema(description = "模版主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "7019")
    @NotNull(message = "Template primary key is required.")
    private Long id;

    @Schema(description = "公众号粉丝的编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Official Accountfollower code is required.")
    private Long userId;

    @Schema(description = "模板跳转链接")
    private String url;

    @Schema(description = "跳转小程序时填写")
    private String miniprogram;

    @Schema(description = "模板内容")
    private Map<String, String> data;

}