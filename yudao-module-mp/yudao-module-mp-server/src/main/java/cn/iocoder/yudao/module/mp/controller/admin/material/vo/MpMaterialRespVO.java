package cn.iocoder.yudao.module.mp.controller.admin.material.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - Official Accountmedia response.")
@Data
public class MpMaterialRespVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Official Account account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long accountId;
    @Schema(description = "Official Account account appId.", requiredMode = Schema.RequiredMode.REQUIRED, example = "wx1234567890")
    private String appId;

    @Schema(description = "Media media_id.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123")
    private String mediaId;

    @Schema(description = "File type see WxConsts.MediaFileType enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "image")
    private String type;

    @Schema(description = "Permanent flag. true=permanent, false=temporary.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean permanent;

    @Schema(description = "Media URL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.png")
    private String url;


    @Schema(description = "Name.", example = "yunai.png")
    private String name;

    @Schema(description = "Official-account file URL. Used only for permanent media.", example = "https://mmbiz.qpic.cn/xxx.mp3")
    private String mpUrl;

    @Schema(description = "Video title. Used only for permanent media.", example = "Me is title.")
    private String title;
    @Schema(description = "Video description. Used only for permanent media.", example = "Me is Intro.")
    private String introduction;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
