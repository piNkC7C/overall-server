package cn.iocoder.yudao.module.oa.controller.admin.mail.vo.provider;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Schema(description = "Enterprise email service setting create / update request VO.")
public class OaMailProviderSaveReqVO {

    @Schema(description = "Service setting code.", example = "1024")
    private Long id;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "companyEmail")
    @NotBlank(message = "Name is required.")
    @Size(max = 255, message = "Name length cannot exceed {max} characters.")
    private String name;

    @Schema(description = "IMAP connect setting.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "IMAP connect setting is required.")
    @Valid
    private ConnectionConfig imap;

    @Schema(description = "SMTP connect setting.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "SMTP connect setting is required.")
    @Valid
    private ConnectionConfig smtp;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status;

    @Schema(description = "Admin - email connect setting request.")
    @Data
    public static class ConnectionConfig {

        @Schema(description = "Server host.", requiredMode = Schema.RequiredMode.REQUIRED, example = "imap.example.com")
        @NotBlank(message = "Server host cannot be empty.")
        @Size(max = 253, message = "Server host cannot exceed 253 characters.")
        private String host;

        /** 校验服务器主机名或 IP，不包含协议、路径和端口 */
        @AssertTrue(message = "Enter a valid server host or IP address.")
        @JsonIgnore
        public boolean isHostValid() {
            if (StrUtil.isEmpty(host)) {
                return true; // 空值由必填校验处理
            }
            if (host.contains(":")) {
                return Validator.isIpv6(host);
            }
            if (host.matches("\\d+(?:\\.\\d+){3}")) {
                return host.matches("(?:25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)(?:\\.(?:25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)){3}");
            }
            return host.matches("(?i)[a-z\\d](?:[a-z\\d-]{0,61}[a-z\\d])?(?:\\.[a-z\\d](?:[a-z\\d-]{0,61}[a-z\\d])?)*\\.?");
        }

        @Schema(description = "Server port.", requiredMode = Schema.RequiredMode.REQUIRED, example = "993")
        @NotNull(message = "Server port cannot be empty.")
        @Min(value = 1, message = "Server port cannot be less than 1.")
        @Max(value = 65535, message = "Server port cannot be greater than 65535.")
        private Integer port;

        @Schema(description = "Is not enable SSL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
        @NotNull(message = "Is not enable SSL is required.")
        private Boolean sslEnable;

        @Schema(description = "Is not enable STARTTLS.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
        @NotNull(message = "Is not enable STARTTLS is required.")
        private Boolean starttlsEnable;

        /**
         * 校验邮箱连接加密方式
         *
         * @return 是否仅启用一种加密方式，空值由字段必填注解校验
         */
        @AssertTrue(message = "Choose SSL or STARTTLS, but not both.")
        @JsonIgnore
        public boolean isEncryptionValid() {
            return sslEnable == null || !sslEnable.equals(starttlsEnable);
        }

    }

}
