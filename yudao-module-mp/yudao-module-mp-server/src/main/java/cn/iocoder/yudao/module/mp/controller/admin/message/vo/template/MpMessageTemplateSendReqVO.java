package cn.iocoder.yudao.module.mp.controller.admin.message.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Map;

@Schema(description = "Admin - Official Accountmessagetemplate send request.") // Relation https://developers.weixin.qq.com/doc/service/api/notify/template/api_sendtemplatemessage.html document
@Data
public class MpMessageTemplateSendReqVO {

    @Schema(description = "Template primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7019")
    @NotNull(message = "Template primary key is required.")
    private Long id;

    @Schema(description = "Official Accountfollower code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Official Accountfollower code is required.")
    private Long userId;

    @Schema(description = "TemplateLink.")
    private String url;

    @Schema(description = "Fill when jumping to a mini program.")
    private String miniprogram;

    @Schema(description = "Template content.")
    private Map<String, String> data;

}