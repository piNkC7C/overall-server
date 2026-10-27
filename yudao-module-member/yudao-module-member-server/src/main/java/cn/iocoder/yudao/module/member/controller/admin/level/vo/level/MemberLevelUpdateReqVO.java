package cn.iocoder.yudao.module.member.controller.admin.level.vo.level;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - member level update request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberLevelUpdateReqVO extends MemberLevelBaseVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "6103")
    @NotNull(message = "Code is required.")
    private Long id;

}
