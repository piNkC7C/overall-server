package cn.iocoder.yudao.module.im.controller.admin.manager.channel.vo.channel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IM Channel response.")
@Data
public class ImChannelRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Channel business code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "system_notice")
    private String code;

    @Schema(description = "Channel name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Systemannouncement.")
    private String name;

    @Schema(description = "ChannelAvatar.")
    private String avatar;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer sort;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status; // See CommonStatusEnum enum class

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
