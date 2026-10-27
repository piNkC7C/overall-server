package cn.iocoder.yudao.module.mes.controller.admin.pro.andon.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "MES andon call setting response VO.")
@Data
public class MesProAndonConfigRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Call Reason", example = "Equipment fault")
    private String reason;

    @Schema(description = "Level.", example = "1")
    private Integer level;

    @Schema(description = "Handle person role code.", example = "10")
    private Long handlerRoleId;

    @Schema(description = "Handle person role name.", example = "Production manager")
    private String handlerRoleName;

    @Schema(description = "Handle person code.", example = "100")
    private Long handlerUserId;

    @Schema(description = "Handle person Nickname.", example = "John.")
    private String handlerUserNickname;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
