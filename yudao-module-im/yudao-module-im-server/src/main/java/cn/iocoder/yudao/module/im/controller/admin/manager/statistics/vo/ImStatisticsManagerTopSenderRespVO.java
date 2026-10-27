package cn.iocoder.yudao.module.im.controller.admin.manager.statistics.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "IM dashboard top sender item response VO.")
@Data
public class ImStatisticsManagerTopSenderRespVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "Nickname", example = "John.")
    private String nickname;

    @Schema(description = "Message count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1500")
    private Long messageCount;

}
