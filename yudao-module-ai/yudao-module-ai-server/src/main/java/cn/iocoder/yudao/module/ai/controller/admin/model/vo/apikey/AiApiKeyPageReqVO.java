package cn.iocoder.yudao.module.ai.controller.admin.model.vo.apikey;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - AI API secret page request.")
@Data
public class AiApiKeyPageReqVO extends PageParam {

    @Schema(description = "Name.", example = "Ernie")
    private String name;

    @Schema(description = "Platform", example = "OpenAI")
    private String platform;

    @Schema(description = "Status.", example = "1")
    private Integer status;

}