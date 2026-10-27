package cn.iocoder.yudao.module.system.controller.admin.notify.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Map;

@Schema(description = "Admin - inbox template send request.")
@Data
public class NotifyTemplateSendReqVO {

    @Schema(description = "Userid.", requiredMode = Schema.RequiredMode.REQUIRED, example = "01")
    @NotNull(message = "Userid is required.")
    private Long userId;

    @Schema(description = "User type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "User type is required.")
    private Integer userType;

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "01")
    @NotEmpty(message = "Template code is required.")
    private String templateCode;

    @Schema(description = "Template parameter.")
    private Map<String, Object> templateParams;

}
