package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.member;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.pm.project.PmsProjectMemberLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS item member save request.")
@Data
public class PmsProjectMemberSaveReqVO {

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Item code is required.")
    private Long projectId;

    @Schema(description = "Item member list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Item member is required.")
    @Valid
    private List<Member> members;

    @Schema(description = "Admin - PMS item member save item.")
    @Data
    public static class Member {

        @Schema(description = "Admin user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Admin user ID cannot be empty.")
        private Long userId;

        @Schema(description = "Member permission level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
        @NotNull(message = "Member permission level is required.")
        @InEnum(PmsProjectMemberLevelEnum.class)
        private Integer level;

    }

}
