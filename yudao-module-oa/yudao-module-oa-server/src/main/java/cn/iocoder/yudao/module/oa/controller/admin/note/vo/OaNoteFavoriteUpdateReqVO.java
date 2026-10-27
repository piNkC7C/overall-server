package cn.iocoder.yudao.module.oa.controller.admin.note.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - OA NoteFavorite status edit request.")
@Data
public class OaNoteFavoriteUpdateReqVO {

    @Schema(description = "Note code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Note code is required.")
    private Long id;

    @Schema(description = "Is not Favorite.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Favorite status is required.")
    private Boolean favorite;

}
