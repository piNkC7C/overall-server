package cn.iocoder.yudao.module.im.controller.admin.group.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import jakarta.validation.constraints.*;

@Schema(description = "Group create / update request VO.")
@Data
public class ImGroupSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1003")
    private Long id;

    @Schema(description = "Group name", example = "Overall.")
    private String name;

    @Schema(description = "Group Owner user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31460")
    @NotNull(message = "Group Owner user ID is required.")
    private Long ownerUserId;

    @Schema(description = "Group avatar.")
    private String avatar;

    @Schema(description = "Group announcement.")
    private String notice;

}