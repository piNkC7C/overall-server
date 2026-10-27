package cn.iocoder.yudao.module.im.controller.admin.group.vo.member;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - invite group members request.")
@Data
public class ImGroupMemberInviteReqVO {

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "13279")
    @NotNull(message = "Group ID is required")
    private Long groupId;

    @Schema(description = "Invited user IDs.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 2, 3]")
    @NotEmpty(message = "Invited user IDs cannot be empty.")
    private List<Long> memberUserIds;

}
