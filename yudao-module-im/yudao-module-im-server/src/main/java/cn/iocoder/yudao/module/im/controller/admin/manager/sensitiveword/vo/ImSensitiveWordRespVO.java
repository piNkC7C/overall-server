package cn.iocoder.yudao.module.im.controller.admin.manager.sensitiveword.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IM Blocked Word response.")
@Data
public class ImSensitiveWordRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Blocked Word", requiredMode = Schema.RequiredMode.REQUIRED, example = "Blocked Word content.")
    private String word;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status; // See CommonStatusEnum enum class

    @Schema(description = "Creator.")
    private String creator;
    @Schema(description = "Creator Nickname.", example = "John.")
    private String creatorName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
