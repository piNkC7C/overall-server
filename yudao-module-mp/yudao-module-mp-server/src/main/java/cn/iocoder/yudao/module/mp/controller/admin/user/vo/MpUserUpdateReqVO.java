package cn.iocoder.yudao.module.mp.controller.admin.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - Official Accountfollowerupdate request.")
@Data
public class MpUserUpdateReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "Nickname", example = "Overall.")
    private String nickname;

    @Schema(description = "Notes.", example = "Are you a potato?")
    private String remark;

    @Schema(description = "Tag ID list.", example = "1,2,3")
    private List<Long> tagIds;

}
