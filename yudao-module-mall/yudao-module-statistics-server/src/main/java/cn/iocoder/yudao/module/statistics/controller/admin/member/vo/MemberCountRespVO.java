package cn.iocoder.yudao.module.statistics.controller.admin.member.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - member quantityStats response.")
@Data
public class MemberCountRespVO {

    @Schema(description = "User visits.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer visitUserCount;

    @Schema(description = "Register user quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer registerUserCount;

}
