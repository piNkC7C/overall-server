package cn.iocoder.yudao.module.infra.controller.admin.logger.vo.apierrorlog;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "API error log page request VO.")
@Data
public class ApiErrorLogPageReqVO extends PageParam {

    @Schema(description = "User ID.", example = "666")
    private Long userId;

    @Schema(description = "User type.", example = "1")
    private Integer userType;

    @Schema(description = "App name.", example = "dashboard")
    private String applicationName;

    @Schema(description = "Request URL.", example = "/xx/yy")
    private String requestUrl;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "Exception time.")
    private LocalDateTime[] exceptionTime;

    @Schema(description = "Process status.", example = "0")
    private Integer processStatus;

}
