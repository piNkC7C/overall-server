package cn.iocoder.yudao.module.ai.controller.admin.image.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - AI image generationpage request.")
@Data
public class AiImagePageReqVO extends PageParam {

    @Schema(description = "User ID.", example = "28987")
    private Long userId;

    @Schema(description = "Platform", example = "OpenAI")
    private String platform;

    @Schema(description = "Prompt", example = "1")
    private String prompt;

    @Schema(description = "Image generationstatus.", example = "1")
    private Integer status;

    @Schema(description = "Is not Publish.", example = "1")
    private Boolean publicStatus;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}