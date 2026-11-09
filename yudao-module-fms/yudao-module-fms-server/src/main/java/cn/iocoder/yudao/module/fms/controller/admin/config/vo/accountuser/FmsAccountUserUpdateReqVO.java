package cn.iocoder.yudao.module.fms.controller.admin.config.vo.accountuser;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.fms.enums.config.FmsAccountUserLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - FMS 账套用户更新 Request VO")
@Data
public class FmsAccountUserUpdateReqVO {

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "账套成员数组", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Books Members group is required.")
    @Size(max = 100, message = "A book can have at most 100 members.")
    @Valid
    private List<Member> members;

    @Schema(description = "管理后台 - FMS 账套成员")
    @Data
    public static class Member {

        @Schema(description = "后台用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Member user ID is required.")
        private Long userId;

        @Schema(description = "成员权限级别", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
        @NotNull(message = "Member permission level is required.")
        @InEnum(FmsAccountUserLevelEnum.class)
        private Integer level;

    }

}
