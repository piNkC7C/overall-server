package cn.iocoder.yudao.module.im.controller.admin.manager.channel.vo.material;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - IM 频道素材新增 / 修改 Request VO")
@Data
public class ImChannelMaterialSaveReqVO {

    @Schema(description = "编号（修改时必填）", example = "1024")
    private Long id;

    @Schema(description = "频道编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Channel ID is required.")
    private Long channelId;

    @Schema(description = "内容类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Content type is required.")
    private Integer type; // See ImChannelMaterialTypeEnum enum class

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "The holiday sale is here")
    @NotBlank(message = "Title is required.")
    @Size(max = 128, message = "Title length cannot exceed 128.")
    private String title;

    @Schema(description = "封面图", example = "https://cdn.example.com/cover.png")
    @Size(max = 512, message = "Cover image URL cannot exceed 512 characters.")
    private String coverUrl;

    @Schema(description = "摘要", example = "50% off storewide. See details.")
    @Size(max = 255, message = "Summary length cannot exceed 255.")
    private String summary;

    @Schema(description = "正文；富文本 HTML")
    private String content;

    @Schema(description = "跳转链接；为空表示走客户端内置详情页", example = "https://example.com/activity/123")
    @Size(max = 512, message = "Link length cannot exceed 512.")
    private String url;

}
