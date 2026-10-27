package cn.iocoder.yudao.module.im.controller.admin.group.vo.member;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Remove group member request VO.")
@Data
public class ImGroupMemberRemoveReqVO {

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Group ID is required")
    private Long groupId;

    @Schema(description = "Removed user IDs.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 2, 3]")
    @NotEmpty(message = "Removed user IDs cannot be empty.")
    private List<Long> memberUserIds;

}
