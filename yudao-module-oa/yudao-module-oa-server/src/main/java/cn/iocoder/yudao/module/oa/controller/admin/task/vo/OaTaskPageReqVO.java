package cn.iocoder.yudao.module.oa.controller.admin.task.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.task.OaTaskStatusEnum;
import cn.iocoder.yudao.module.oa.enums.task.OaTaskTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - OA task page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaTaskPageReqVO extends PageParam {

    @Schema(description = "Title.", example = "Complete OA task admin transition.")
    private String title;

    @Schema(description = "Task type.", example = "1")
    @InEnum(value = OaTaskTypeEnum.class, message = "Task type must be {value}.")
    private Integer type;

    @Schema(description = "Task status.", example = "1")
    @InEnum(value = OaTaskStatusEnum.class, message = "Task status must be {value}.")
    private Integer status;

    @Schema(description = "Is not cancel.", example = "false")
    private Boolean canceled;

    @Schema(description = "Publisher user ID.", example = "1")
    private Long publisherUserId;

    @Schema(description = "PublishedRange.", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] publishTime;

}
