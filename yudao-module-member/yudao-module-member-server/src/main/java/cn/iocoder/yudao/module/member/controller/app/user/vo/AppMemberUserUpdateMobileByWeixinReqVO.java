package cn.iocoder.yudao.module.member.controller.app.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(description = "Based on WeChat mini program authorization code, update mobile request VO.")
@Data
public class AppMemberUserUpdateMobileByWeixinReqVO {

    @Schema(description = "Phone code from wx.getPhoneNumber in the mini program.",
            requiredMode = Schema.RequiredMode.REQUIRED, example = "hello")
    @NotEmpty(message = "Mobile code is required.")
    private String code;

}
