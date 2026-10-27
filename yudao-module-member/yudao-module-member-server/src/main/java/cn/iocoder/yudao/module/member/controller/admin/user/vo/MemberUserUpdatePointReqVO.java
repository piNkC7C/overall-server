package cn.iocoder.yudao.module.member.controller.admin.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - user edit points request.")
@Data
@ToString(callSuper = true)
public class MemberUserUpdatePointReqVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23788")
    @NotNull(message = "User ID is required.")
    private Long id;

    @Schema(description = "Points change. Positive adds, negative subtracts.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Points change cannot be empty.")
    private Integer point;

}
