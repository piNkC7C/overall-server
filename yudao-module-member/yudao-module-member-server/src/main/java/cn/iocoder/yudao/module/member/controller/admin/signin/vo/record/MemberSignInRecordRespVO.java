package cn.iocoder.yudao.module.member.controller.admin.signin.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Check-in record response VO.")
@Data
public class MemberSignInRecordRespVO {

    @Schema(description = "Check-in auto ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11903")
    private Long id;

    @Schema(description = "Check-in user.", requiredMode = Schema.RequiredMode.REQUIRED, example = "6507")
    private Long userId;

    @Schema(description = "Nickname", example = "John.")
    private String nickname;

    @Schema(description = "Check-in day.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer day;

    @Schema(description = "Check-in points.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer point;

    @Schema(description = "Check-in Time", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
