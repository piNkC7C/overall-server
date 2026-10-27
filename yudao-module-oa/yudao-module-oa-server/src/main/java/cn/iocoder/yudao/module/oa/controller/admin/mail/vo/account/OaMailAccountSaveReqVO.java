package cn.iocoder.yudao.module.oa.controller.admin.mail.vo.account;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;

@Data
@Schema(description = "Enterprise email account create / update request VO.")
public class OaMailAccountSaveReqVO {

    @Schema(description = "Account code.", example = "1024")
    private Long id;

    @Schema(description = "Service setting code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Service setting code is required.")
    private Long providerId;

    @Schema(description = "EmailAddress.", requiredMode = Schema.RequiredMode.REQUIRED, example = "user@example.com")
    @NotBlank(message = "EmailAddress is required.")
    @Email(message = "EmailAddress format is invalid.")
    @Size(max = 255, message = "EmailAddress length cannot exceed {max} characters.")
    private String mail;

    @Schema(description = "Sign-in username.", requiredMode = Schema.RequiredMode.REQUIRED, example = "user@example.com")
    @NotBlank(message = "Sign-in username is required.")
    @Size(max = 255, message = "Sign-in username length cannot exceed {max} characters.")
    private String username;

    @Schema(description = "Password or app password. Required when creating. Leave empty when editing to keep the current value.", accessMode = Schema.AccessMode.WRITE_ONLY)
    @ToString.Exclude
    @Size(max = 4096, message = "Password or Authorization code length cannot exceed {max} characters.")
    private String password;

    @Schema(description = "Default sender account.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Default sender account cannot be empty.")
    private Boolean defaultStatus;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
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
