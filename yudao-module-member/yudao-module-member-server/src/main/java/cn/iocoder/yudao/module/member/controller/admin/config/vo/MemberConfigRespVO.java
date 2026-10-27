package cn.iocoder.yudao.module.member.controller.admin.config.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - membersetting response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberConfigRespVO extends MemberConfigBaseVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

}
