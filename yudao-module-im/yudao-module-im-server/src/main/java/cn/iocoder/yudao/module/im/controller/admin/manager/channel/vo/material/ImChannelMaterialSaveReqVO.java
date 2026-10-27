package cn.iocoder.yudao.module.im.controller.admin.manager.channel.vo.material;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - IM Channelmedia create / edit request.")
@Data
public class ImChannelMaterialSaveReqVO {

    @Schema(description = "ID (required when updating).", example = "1024")
    private Long id;

    @Schema(description = "Channel ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Channel ID is required.")
    private Long channelId;

    @Schema(description = "Content type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Content type is required.")
    private Integer type; // See ImChannelMaterialTypeEnum enum class

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "The holiday sale is here")
    @NotBlank(message = "Title is required.")
    @Size(max = 128, message = "Title length cannot exceed 128.")
    private String title;

    @Schema(description = "Cover image.", example = "https://cdn.example.com/cover.png")
    @Size(max = 512, message = "Cover image URL cannot exceed 512 characters.")
    private String coverUrl;

    @Schema(description = "Summary", example = "50% off storewide. See details.")
    @Size(max = 255, message = "Summary length cannot exceed 255.")
    private String summary;

    @Schema(description = "Body; rich text HTML.")
    private String content;

    @Schema(description = "Jump URL. Empty means the built-in client detail page.", example = "https://example.com/activity/123")
    @Size(max = 512, message = "Link length cannot exceed 512.")
    private String url;

}
