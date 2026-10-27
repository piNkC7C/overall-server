package cn.iocoder.yudao.module.oa.controller.admin.note.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.note.OaNoteTypeEnum;
import cn.iocoder.yudao.module.oa.enums.schedule.OaPriorityEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - OA Note page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaNotePageReqVO extends PageParam {

    @Schema(description = "Title.", example = "Meeting minutes")
    private String title;

    @Schema(description = "Directory code.", example = "1024")
    private Long categoryId;

    @Schema(description = "Note type.", example = "1")
    @InEnum(value = OaNoteTypeEnum.class, message = "Note type must be {value}.")
    private Integer type;

    @Schema(description = "Priority", example = "1")
    @InEnum(value = OaPriorityEnum.class, message = "Priority must be {value}.")
    private Integer priority;

    @Schema(description = "Is not Favorite.", example = "false")
    private Boolean favorite;

    @Schema(description = "Create time range.", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;


}
