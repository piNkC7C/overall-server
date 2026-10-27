package cn.iocoder.yudao.module.system.controller.admin.permission.vo.role;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - role page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class RolePageReqVO extends PageParam {

    @Schema(description = "Role name, fuzzy match.", example = "Overall.")
    private String name;

    @Schema(description = "Role key, fuzzy match.", example = "yudao")
    private String code;

    @Schema(description = "Display status. See CommonStatusEnum.", example = "1")
    private Integer status;

    @Schema(description = "Create time.", example = "[2022-07-01 00:00:00,2022-07-01 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
