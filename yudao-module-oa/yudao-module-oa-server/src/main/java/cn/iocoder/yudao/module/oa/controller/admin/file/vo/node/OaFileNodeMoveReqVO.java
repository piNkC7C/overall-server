package cn.iocoder.yudao.module.oa.controller.admin.file.vo.node;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Cloud drive move request VO.")
@Data
public class OaFileNodeMoveReqVO {

    @Schema(description = "Node code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Node code is required.")
    private Long id;

    @Schema(description = "Target directory code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Target directory code is required.")
    private Long parentId;

}
