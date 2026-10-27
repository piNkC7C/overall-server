package cn.iocoder.yudao.module.member.controller.admin.signin.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "Check-in rule response VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberSignInConfigRespVO extends MemberSignInConfigBaseVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20937")
    private Integer id;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
