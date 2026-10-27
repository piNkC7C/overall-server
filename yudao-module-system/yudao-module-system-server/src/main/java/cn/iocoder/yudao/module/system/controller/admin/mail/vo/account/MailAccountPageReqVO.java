package cn.iocoder.yudao.module.system.controller.admin.mail.vo.account;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - email account page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MailAccountPageReqVO extends PageParam {

    @Schema(description = "Email", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudaoyuanma@123.com")
    private String mail;

    @Schema(description = "Username." , requiredMode = Schema.RequiredMode.REQUIRED , example = "yudao")
    private String username;

}
