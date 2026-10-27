package cn.iocoder.yudao.module.member.controller.admin.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - user edit level request.")
@Data
@ToString(callSuper = true)
public class MemberUserUpdateLevelReqVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23788")
    @NotNull(message = "User ID is required.")
    private Long id;

    /**
     * 取消用户等级时，值为空
     */
    @Schema(description = "User level code.", example = "1")
    private Long levelId;

    @Schema(description = "Edit reason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Marketing need")
    @NotBlank(message = "Edit reason is required.")
    private String reason;

}
