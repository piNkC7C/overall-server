package cn.iocoder.yudao.module.member.controller.admin.tag.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - membertag response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberTagRespVO extends MemberTagBaseVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "907")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
