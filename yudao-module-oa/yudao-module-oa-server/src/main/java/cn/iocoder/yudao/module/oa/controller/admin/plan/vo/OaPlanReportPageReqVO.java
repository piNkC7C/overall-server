package cn.iocoder.yudao.module.oa.controller.admin.plan.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.plan.OaPlanTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "OA work plan report page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaPlanReportPageReqVO extends PageParam {

    @Schema(description = "Member Nickname.", example = "Overall.")
    private String userName;

    @Schema(description = "Plan type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Plan type is required.")
    @InEnum(value = OaPlanTypeEnum.class, message = "Plan type must be {value}.")
    private Integer type;

    @Schema(description = "Create time range.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @NotNull(message = "Create time range is required.")
    @Size(min = 2, max = 2, message = "Create time range format is invalid.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
