package cn.iocoder.yudao.module.member.controller.admin.level.vo.level;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Schema(description = "Member level list filter request VO.")
@Data
@ToString(callSuper = true)
public class MemberLevelListReqVO {

    @Schema(description = "Level name.", example = "Overall.")
    private String name;

    @Schema(description = "Status.", example = "1")
    private Integer status;

}
