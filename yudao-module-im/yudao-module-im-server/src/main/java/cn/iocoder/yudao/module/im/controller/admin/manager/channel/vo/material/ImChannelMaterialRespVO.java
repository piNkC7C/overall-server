package cn.iocoder.yudao.module.im.controller.admin.manager.channel.vo.material;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IM Channelmedia response.")
@Data
public class ImChannelMaterialRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Channel ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long channelId;

    @Schema(description = "Channel name (joined).")
    private String channelName;

    @Schema(description = "Content type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type; // See ImChannelMaterialTypeEnum enum class

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @Schema(description = "Cover image.")
    private String coverUrl;

    @Schema(description = "Summary")
    private String summary;

    @Schema(description = "Body; rich text HTML.")
    private String content;

    @Schema(description = "Link")
    private String url;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
