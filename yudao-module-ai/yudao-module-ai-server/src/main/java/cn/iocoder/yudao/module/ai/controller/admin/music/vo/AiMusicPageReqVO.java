package cn.iocoder.yudao.module.ai.controller.admin.music.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.ai.enums.music.AiMusicGenerateModeEnum;
import cn.iocoder.yudao.module.ai.enums.music.AiMusicStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - AI musicpage request.")
@Data
public class AiMusicPageReqVO extends PageParam {

    @Schema(description = "User ID.", example = "12212")
    private Long userId;

    @Schema(description = "Music name.", example = "Brightest star")
    private String title;

    @Schema(description = "Musicstatus.", example = "20")
    @InEnum(AiMusicStatusEnum.class)
    private Integer status;

    @Schema(description = "Generate mode.", example = "1")
    @InEnum(AiMusicGenerateModeEnum.class)
    private Integer generateMode;

    @Schema(description = "Is not Publish.", example = "true")
    private Boolean publicStatus;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}