package cn.iocoder.yudao.module.statistics.controller.admin.member.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - Member AppStats response.")
@Data
public class MemberTerminalStatisticsRespVO {

    @Schema(description = "Terminal.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer terminal;

    // TODO @疯狂：要不 orderCreateUserCount 和 orderPayUserCount 貌似更统一一些；
    @Schema(description = "Member quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer userCount;

}
