package cn.iocoder.yudao.module.member.controller.admin.group.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Schema(description = "Admin - user group response.")
@Data
@ToString(callSuper = true)
public class MemberGroupSimpleRespVO {

    @Schema(description = "Code.", example = "6103")
    private Long id;

    @Schema(description = "Level name.", example = "Overall.")
    private String name;

}
