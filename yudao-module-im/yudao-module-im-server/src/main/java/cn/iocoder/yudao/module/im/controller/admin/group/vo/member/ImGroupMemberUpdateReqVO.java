package cn.iocoder.yudao.module.im.controller.admin.group.vo.member;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Schema(description = "Group member update request VO.")
@Data
@Accessors(chain = true)
public class ImGroupMemberUpdateReqVO {

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Group ID is required")
    private Long groupId;

    @Schema(description = "Group nickname.", example = "Taro")
    private String displayUserName;

    @Schema(description = "Group remark.", example = "Company group")
    private String groupRemark;

    @Schema(description = "Is not Do Not Disturb.")
    private Boolean silent;

}
