package cn.iocoder.yudao.module.member.controller.app.auth.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.common.validation.Mobile;
import cn.iocoder.yudao.module.system.enums.sms.SmsSceneEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "User APP - send SMS code request.")
@Data
public class AppAuthSmsSendReqVO {

    @Schema(description = "Phone number.", example = "15601691234")
    @Mobile
    private String mobile;

    @Schema(description = "Send scene, matching SmsSceneEnum enum.", example = "1")
    @NotNull(message = "Send scene is required")
    @InEnum(SmsSceneEnum.class)
    private Integer scene;

}
