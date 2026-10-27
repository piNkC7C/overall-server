package cn.iocoder.yudao.module.member.controller.app.point.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "User App - user points record response.")
@Data
public class AppMemberPointRecordRespVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31457")
    private Long id;

    @Schema(description = "Points title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Example.")
    private String title;

    @Schema(description = "Points Description.", example = "Example.")
    private String description;

    @Schema(description = "Points.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer point;

    @Schema(description = "Occurred at.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
