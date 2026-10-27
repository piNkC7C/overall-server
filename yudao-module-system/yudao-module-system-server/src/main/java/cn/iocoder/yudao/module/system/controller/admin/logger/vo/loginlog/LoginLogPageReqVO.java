package cn.iocoder.yudao.module.system.controller.admin.logger.vo.loginlog;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Sign-in log page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class LoginLogPageReqVO extends PageParam {

    @Schema(description = "User IP, mock match.", example = "127.0.0.1")
    private String userIp;

    @Schema(description = "Username, fuzzy match.", example = "Overall.")
    private String username;

    @Schema(description = "Action status.", example = "true")
    private Boolean status;

    @Schema(description = "Sign-in time.", example = "[2022-07-01 00:00:00,2022-07-01 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
