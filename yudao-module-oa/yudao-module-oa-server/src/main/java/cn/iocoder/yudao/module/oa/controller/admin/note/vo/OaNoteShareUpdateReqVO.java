package cn.iocoder.yudao.module.oa.controller.admin.note.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "OA note share update request VO.")
@Data
public class OaNoteShareUpdateReqVO {

    @Schema(description = "Note code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Note code is required.")
    private Long id;

    @Schema(description = "Recipient user IDs. An empty list cancels all shares.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 2]")
    @NotNull(message = "Recipient list is required.")
    private List<@NotNull(message = "Recipient code is required.") Long> receiverUserIds;

}
