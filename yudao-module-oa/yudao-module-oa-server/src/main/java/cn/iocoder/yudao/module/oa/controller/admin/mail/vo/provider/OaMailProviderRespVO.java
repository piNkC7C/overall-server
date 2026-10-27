package cn.iocoder.yudao.module.oa.controller.admin.mail.vo.provider;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - email service setting response.")
@Data
public class OaMailProviderRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "companyEmail")
    private String name;

    @Schema(description = "IMAP connect setting.")
    private OaMailProviderSaveReqVO.ConnectionConfig imap;

    @Schema(description = "SMTP connect setting.")
    private OaMailProviderSaveReqVO.ConnectionConfig smtp;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

}
