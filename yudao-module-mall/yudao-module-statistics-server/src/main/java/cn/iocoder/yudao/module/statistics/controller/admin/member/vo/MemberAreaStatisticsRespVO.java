package cn.iocoder.yudao.module.statistics.controller.admin.member.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - MemberregionStats response.")
@Data
public class MemberAreaStatisticsRespVO {

    @Schema(description = "Province ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer areaId;
    @Schema(description = "Province name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Zhejiang")
    private String areaName;

    @Schema(description = "Member quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer userCount;

    @Schema(description = "Order member quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer orderCreateUserCount;
    @Schema(description = "Payment member quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "512")
    private Integer orderPayUserCount;

    @Schema(description = "Order payment amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "622")
    private Integer orderPayPrice;

}
