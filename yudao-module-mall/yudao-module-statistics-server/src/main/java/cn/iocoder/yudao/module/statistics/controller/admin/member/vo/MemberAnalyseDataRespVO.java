package cn.iocoder.yudao.module.statistics.controller.admin.member.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Member analysis data response VO.")
@Data
public class MemberAnalyseDataRespVO {

    @Schema(description = "Member quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer registerUserCount;

    @Schema(description = "Active users.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer visitUserCount;

    @Schema(description = "Top-up member quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "221")
    private Integer rechargeUserCount;

}
