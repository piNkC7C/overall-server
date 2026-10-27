package cn.iocoder.yudao.module.system.controller.admin.logger.vo.operatelog;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - Activity Log page list request.")
@Data
public class OperateLogPageReqVO extends PageParam {

    @Schema(description = "User ID.", example = "Overall.")
    private Long userId;

    @Schema(description = "Module business code.", example = "1")
    private Long bizId;

    @Schema(description = "Module, fuzzy match.", example = "Order.")
    private String type;

    @Schema(description = "Action name, fuzzy match.", example = "Createorder.")
    private String subType;

    @Schema(description = "Action detail, fuzzy match.", example = "Edit code is 1 user info.")
    private String action;

    @Schema(description = "Start time.", example = "[2022-07-01 00:00:00,2022-07-01 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
