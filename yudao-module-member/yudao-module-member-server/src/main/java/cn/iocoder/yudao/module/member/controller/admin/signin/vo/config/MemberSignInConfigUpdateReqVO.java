package cn.iocoder.yudao.module.member.controller.admin.signin.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import jakarta.validation.constraints.*;

@Schema(description = "Check-in rule update request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberSignInConfigUpdateReqVO extends MemberSignInConfigBaseVO {

    @Schema(description = "Rule ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13653")
    @NotNull(message = "Rule ID cannot be empty.")
    private Long id;

}
