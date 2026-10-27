package cn.iocoder.yudao.module.infra.controller.admin.config.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - setting page request.")
@Data
public class ConfigPageReqVO extends PageParam {

    @Schema(description = "Data source name, fuzzy match.", example = "Name.")
    private String name;

    @Schema(description = "Config key, fuzzy match.", example = "yunai.db.username")
    private String key;

    @Schema(description = "Parameter type, see SysConfigTypeEnum enum.", example = "1")
    private Integer type;

    @Schema(description = "Create time.", example = "[2022-07-01 00:00:00,2022-07-01 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
