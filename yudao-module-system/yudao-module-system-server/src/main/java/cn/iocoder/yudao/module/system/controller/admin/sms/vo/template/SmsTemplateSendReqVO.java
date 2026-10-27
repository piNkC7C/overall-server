package cn.iocoder.yudao.module.system.controller.admin.sms.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.util.Map;

@Schema(description = "Admin - SMS template send request.")
@Data
public class SmsTemplateSendReqVO {

    @Schema(description = "Phone number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300")
    @NotNull(message = "Phone number is required.")
    private String mobile;

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "test_01")
    @NotNull(message = "Template code is required.")
    private String templateCode;

    @Schema(description = "Template parameter.")
    private Map<String, Object> templateParams;

}
