package cn.iocoder.yudao.module.ai.controller.admin.music.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - AI 音乐生成 Request VO")
@Data
public class AiSunoGenerateReqVO {

    @Schema(description = "平台", requiredMode = Schema.RequiredMode.REQUIRED, example = "Suno")
    @NotBlank(message = "Platform is required.")
    private String platform; // See AiPlatformEnum enum

    /**
     * 1. 描述模式：描述词 + 是否纯音乐 + 模型
     * 2. 歌词模式：歌词 + 音乐风格 + 标题 + 模型
     */
    @Schema(description = "生成模式", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Generate mode cannot be empty.")
    private Integer generateMode; // See AiMusicGenerateModeEnum enum

    @Schema(description = "用于生成音乐音频的歌词提示",
            example = """1. Description mode: Write a pop song with a light guitar melody. [verse] describes a quiet summer beach. [chorus] picks up the tempo and longs for freedom.\n2. Lyrics mode:\n[Verse]\nRunning in the sun, so carefree\nVacation is coming, my heart takes flight\nFriends beside me, laughter all around\nEvery sweet day without a worry\n[Chorus]\nBreak is almost here, come celebrate\nLet's go travel, let's go explore\nDays are too short, don't wait\nBreak is almost here, dreams take off""")
    private String prompt;

    @Schema(description = "是否纯音乐", example = "true")
    private Boolean makeInstrumental;

    @Schema(description = "模型", requiredMode = Schema.RequiredMode.REQUIRED, example = "chirp-v3.5")
    @NotEmpty(message = "Model is required.")
    private String model;

    @Schema(description = "音乐风格", example = "[\"pop\",\"jazz\",\"punk\"]")
    private List<String> tags;

    @Schema(description = "音乐/歌曲名称", example = "Brightest star")
    private String title;

}