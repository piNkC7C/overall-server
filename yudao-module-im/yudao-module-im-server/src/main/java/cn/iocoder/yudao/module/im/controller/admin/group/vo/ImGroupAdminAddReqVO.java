package cn.iocoder.yudao.module.im.controller.admin.group.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Add a group admin request VO.")
@Data
public class ImGroupAdminAddReqVO {

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "13279")
    @NotNull(message = "Group ID is required")
    private Long id;

    @Schema(description = "Target user ID list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[101, 102]")
    @NotEmpty(message = "Target user ID list is required.")
    private List<Long> userIds;

}
