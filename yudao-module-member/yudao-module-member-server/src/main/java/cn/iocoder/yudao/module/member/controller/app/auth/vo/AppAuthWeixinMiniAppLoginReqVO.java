package cn.iocoder.yudao.module.member.controller.app.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;

@Schema(description = "App - WeChatmini programMobilesign-in request.")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppAuthWeixinMiniAppLoginReqVO {

    @Schema(description = "Phone code from wx.getPhoneNumber in the mini program.", requiredMode = Schema.RequiredMode.REQUIRED, example = "hello")
    @NotEmpty(message = "Mobile code is required.")
    private String phoneCode;

    @Schema(description = "Login code from wx.login in the mini program.", requiredMode = Schema.RequiredMode.REQUIRED, example = "word")
    @NotEmpty(message = "Sign-in code is required.")
    private String loginCode;

    @Schema(description = "state", requiredMode = Schema.RequiredMode.REQUIRED, example = "9b2ffbc1-7425-4155-9894-9d5c08541d62")
    @NotEmpty(message = "State is required.")
    private String state;

}
