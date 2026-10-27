package cn.iocoder.yudao.module.mp.controller.admin.tag.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - Official Accounttag response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MpTagRespVO extends MpTagBaseVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "This tag follower quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer count;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
