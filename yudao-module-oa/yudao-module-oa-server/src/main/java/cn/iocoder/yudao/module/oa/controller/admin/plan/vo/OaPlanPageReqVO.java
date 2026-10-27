package cn.iocoder.yudao.module.oa.controller.admin.plan.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.plan.OaPlanStatusEnum;
import cn.iocoder.yudao.module.oa.enums.plan.OaPlanTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - OA Work Planpage request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaPlanPageReqVO extends PageParam {

    @Schema(description = "Title.", example = "This week's plan")
    private String title;

    @Schema(description = "Tag.", example = "Key")
    private String label;

    @Schema(description = "Plan type.", example = "1")
    @InEnum(value = OaPlanTypeEnum.class, message = "Plan type must be {value}.")
    private Integer type;

    @Schema(description = "Plan status.", example = "1")
    @InEnum(value = OaPlanStatusEnum.class, message = "Plan status must be {value}.")
    private Integer status;

    @Schema(description = "Create time range.", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
