package cn.iocoder.yudao.module.member.controller.admin.point.vo.recrod;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - user points record response.")
@Data
public class MemberPointRecordRespVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31457")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "Nickname", example = "John.")
    private String nickname;

    @Schema(description = "Business code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "22706")
    private String bizId;

    @Schema(description = "Business type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer bizType;

    @Schema(description = "Points title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Example.")
    private String title;

    @Schema(description = "Points Description.", example = "Example.")
    private String description;

    @Schema(description = "Points.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer point;

    @Schema(description = "Points after change.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    private Integer totalPoint;

    @Schema(description = "Occurred at.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
