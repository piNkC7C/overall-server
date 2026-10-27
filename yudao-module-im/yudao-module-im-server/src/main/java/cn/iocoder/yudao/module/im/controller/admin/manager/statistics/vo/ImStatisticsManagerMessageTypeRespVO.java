package cn.iocoder.yudao.module.im.controller.admin.manager.statistics.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "IM dashboard content-type distribution item response VO.")
@Data
public class ImStatisticsManagerMessageTypeRespVO {

    @Schema(description = "Message type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer type; // See ImContentTypeEnum enum class

    @Schema(description = "Message count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8000")
    private Long value;

}
