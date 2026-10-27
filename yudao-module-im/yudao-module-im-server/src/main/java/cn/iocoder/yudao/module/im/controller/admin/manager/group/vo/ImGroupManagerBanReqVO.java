package cn.iocoder.yudao.module.im.controller.admin.manager.group.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "IM group ban request VO.")
@Data
public class ImGroupManagerBanReqVO {

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Group ID is required")
    private Long id;

    @Schema(description = "Ban reason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Policy-violating content")
    @NotBlank(message = "Ban reason cannot be empty.")
    @Size(max = 200, message = "Ban reason cannot exceed 200 characters.")
    private String reason;

}
