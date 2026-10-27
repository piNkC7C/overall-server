package cn.iocoder.yudao.module.im.controller.admin.group.vo.member;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - invite group members request.")
@Data
public class ImGroupMemberCreateReqVO {

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "13279")
    @NotNull(message = "Group ID is required")
    private Long groupId;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "21730")
    @NotNull(message = "User ID is required.")
    private Long userId;

}
