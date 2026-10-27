package cn.iocoder.yudao.module.im.controller.admin.manager.statistics.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "IM dashboard group-size distribution item response VO.")
@Data
public class ImStatisticsManagerGroupSizeRespVO {

    @Schema(description = "Range name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1-9 person.")
    private String range;

    @Schema(description = "Group count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "320")
    private Long count;

}
