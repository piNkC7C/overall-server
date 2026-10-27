package cn.iocoder.yudao.module.fms.controller.admin.config.vo.accountuser;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.fms.enums.config.FmsAccountUserLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - FMS books userupdate request.")
@Data
public class FmsAccountUserUpdateReqVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Books Members group.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Books Members group is required.")
    @Size(max = 100, message = "A book can have at most 100 members.")
    @Valid
    private List<Member> members;

    @Schema(description = "Admin - FMS books member.")
    @Data
    public static class Member {

        @Schema(description = "Admin user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Member user ID is required.")
        private Long userId;

        @Schema(description = "Member permission level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
        @NotNull(message = "Member permission level is required.")
        @InEnum(FmsAccountUserLevelEnum.class)
        private Integer level;

    }

}
