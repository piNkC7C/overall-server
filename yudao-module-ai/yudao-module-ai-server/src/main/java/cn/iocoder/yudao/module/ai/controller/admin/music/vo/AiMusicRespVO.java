package cn.iocoder.yudao.module.ai.controller.admin.music.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - AI music response.")
@Data
public class AiMusicRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24790")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12212")
    private Long userId;

    @Schema(description = "Music name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Brightest star")
    private String title;

    @Schema(description = "Lyrics.", example = "Oh my")
    private String lyric;

    @Schema(description = "ImageAddress.", example = "https://www.iocoder.cn")
    private String imageUrl;

    @Schema(description = "Audio URL.", example = "https://www.iocoder.cn")
    private String audioUrl;

    @Schema(description = "Video Address.", example = "https://www.iocoder.cn")
    private String videoUrl;

    @Schema(description = "Musicstatus.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Integer status;

    @Schema(description = "Prompt.", example = "An upbeat song")
    private String gptDescriptionPrompt;

    @Schema(description = "Prompt", example = "Write a pop song with a light guitar melody. [verse] describes a quiet summer beach. [chorus] speeds up and expresses a wish for freedom.")
    private String prompt;

    @Schema(description = "ModelPlatform.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Suno")
    private String platform;

    @Schema(description = "Model.", requiredMode = Schema.RequiredMode.REQUIRED, example = "chirp-v3.5")
    private String model;

    @Schema(description = "Generate mode.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer generateMode;

    @Schema(description = "Music style tags.")
    private List<String> tags;

    @Schema(description = "Music duration.", example = "[\"pop\",\"jazz\",\"punk\"]")
    private Double duration;

    @Schema(description = "Is not Publish.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean publicStatus;

    @Schema(description = "Task code.", example = "11369")
    private String taskId;

    @Schema(description = "Error info.")
    private String errorMessage;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}