package cn.iocoder.yudao.module.bpm.controller.admin.oa.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - leave request page request.")
@Data
public class BpmOALeavePageReqVO extends PageParam {

    @Schema(description = "Status.", example = "1")
    private Integer status; // See BpmProcessInstanceResultEnum enum

    @Schema(description = "Leave Type, see bpm_oa_type.", example = "1")
    private Integer type;

    @Schema(description = "Reason, fuzzy match.", example = "Read the docs")
    private String reason;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "Apply please time.")
    private LocalDateTime[] createTime;

}
