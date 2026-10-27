package cn.iocoder.yudao.module.member.controller.admin.group.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - user groupupdate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberGroupUpdateReqVO extends MemberGroupBaseVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20357")
    @NotNull(message = "Code is required.")
    private Long id;

}
