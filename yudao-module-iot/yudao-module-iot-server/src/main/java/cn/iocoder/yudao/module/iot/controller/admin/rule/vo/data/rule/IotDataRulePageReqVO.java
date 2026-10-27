package cn.iocoder.yudao.module.iot.controller.admin.rule.vo.data.rule;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - IoT data flow rule page request.")
@Data
public class IotDataRulePageReqVO extends PageParam {

    @Schema(description = "Data flow rule name.", example = "Overall.")
    private String name;

    @Schema(description = "Data flow rule status.", example = "1")
    private Integer status;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}