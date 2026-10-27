package cn.iocoder.yudao.module.member.controller.app.point.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "User App - user points record page request.")
@Data
public class AppMemberPointRecordPageReqVO extends PageParam {

    @Schema(description = "Add points.", example = "true")
    private Boolean addStatus; // true - 增加；false - 减少；null - 不筛选

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "Create time.")
    private LocalDateTime[] createTime;

}
