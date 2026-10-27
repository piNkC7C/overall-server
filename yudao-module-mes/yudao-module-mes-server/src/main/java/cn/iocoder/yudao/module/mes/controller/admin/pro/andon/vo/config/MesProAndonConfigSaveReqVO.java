package cn.iocoder.yudao.module.mes.controller.admin.pro.andon.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "MES andon call setting create / update request VO.")
@Data
public class MesProAndonConfigSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Call Reason", requiredMode = Schema.RequiredMode.REQUIRED, example = "Equipment fault")
    @NotEmpty(message = "Call Reason is required.")
    private String reason;

    @Schema(description = "Level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Level is required.")
    private Integer level;

    @Schema(description = "Handle person role code.", example = "10")
    private Long handlerRoleId;

    @Schema(description = "Handle person code.", example = "100")
    private Long handlerUserId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
