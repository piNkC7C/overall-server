package cn.iocoder.yudao.module.oa.controller.admin.mail.vo.account;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;

@Data
@Schema(description = "管理后台 - 企业邮箱账号新增/修改 Request VO")
public class OaMailAccountSaveReqVO {

    @Schema(description = "账号编号", example = "1024")
    private Long id;

    @Schema(description = "服务配置编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Service setting code is required.")
    private Long providerId;

    @Schema(description = "邮箱地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "user@example.com")
    @NotBlank(message = "EmailAddress is required.")
    @Email(message = "EmailAddress format is invalid.")
    @Size(max = 255, message = "EmailAddress length cannot exceed {max} characters.")
    private String mail;

    @Schema(description = "登录用户名", requiredMode = Schema.RequiredMode.REQUIRED, example = "user@example.com")
    @NotBlank(message = "Sign-in username is required.")
    @Size(max = 255, message = "Sign-in username length cannot exceed {max} characters.")
    private String username;

    @Schema(description = "密码或授权码，新增时必填，修改时留空表示不变", accessMode = Schema.AccessMode.WRITE_ONLY)
    @ToString.Exclude
    @Size(max = 4096, message = "Password or Authorization code length cannot exceed {max} characters.")
    private String password;

    @Schema(description = "是否默认发件账号", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Default sender account cannot be empty.")
    private Boolean defaultStatus;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status;

    /**
     * 校验默认邮箱账号的启用状态
     *
     * @return 是否符合默认账号规则
     */
    @AssertTrue(message = "Default email account must Enabled.")
    @JsonIgnore
    public boolean isDefaultStatusValid() {
        return !Boolean.TRUE.equals(defaultStatus) || CommonStatusEnum.ENABLE.getStatus().equals(status);
    }

}
