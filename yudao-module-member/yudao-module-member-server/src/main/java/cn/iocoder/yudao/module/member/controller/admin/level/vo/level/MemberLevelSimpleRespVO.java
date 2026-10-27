package cn.iocoder.yudao.module.member.controller.admin.level.vo.level;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Schema(description = "Admin - member level response.")
@Data
@ToString(callSuper = true)
public class MemberLevelSimpleRespVO {

    @Schema(description = "Code.", example = "6103")
    private Long id;

    @Schema(description = "Level name.", example = "Overall.")
    private String name;

    @Schema(description = "Level Icon.", example = "https://www.iocoder.cn/yudao.jpg")
    private String icon;

}
