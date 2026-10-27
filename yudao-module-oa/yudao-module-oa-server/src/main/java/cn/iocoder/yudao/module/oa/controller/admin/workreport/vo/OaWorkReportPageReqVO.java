package cn.iocoder.yudao.module.oa.controller.admin.workreport.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.workreport.OaWorkReportStatusEnum;
import cn.iocoder.yudao.module.oa.enums.workreport.OaWorkReportTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "OA my work report page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaWorkReportPageReqVO extends PageParam {

    @Schema(description = "Report type.", example = "1")
    @InEnum(value = OaWorkReportTypeEnum.class, message = "Report type must be {value}.")
    private Integer type;

    @Schema(description = "Report status.", example = "1")
    @InEnum(value = OaWorkReportStatusEnum.class, message = "Report status must be {value}.")
    private Integer status;

    @Schema(description = "Report number.", example = "HB202609140001")
    private String no;

    @Schema(description = "Department code.", example = "1024")
    private Long deptId;

    @Schema(description = "Report start time range.", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] periodTime;

    @Schema(description = "Start Date.", example = "2026-09-14 09:00:00")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime startTime;

    @Schema(description = "End Date.", example = "2026-09-14 18:00:00")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

    @Schema(description = "Create time.", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
