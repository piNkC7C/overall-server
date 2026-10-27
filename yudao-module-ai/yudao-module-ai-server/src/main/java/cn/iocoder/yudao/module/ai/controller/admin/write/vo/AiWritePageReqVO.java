package cn.iocoder.yudao.module.ai.controller.admin.write.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "AI writing page request VO.")
@Data
public class AiWritePageReqVO extends PageParam {

    @Schema(description = "User ID.", example = "28404")
    private Long userId;

    @Schema(description = "Writing type.", example = "1")
    private Integer type;

    @Schema(description = "Platform", example = "TongYi")
    private String platform;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}