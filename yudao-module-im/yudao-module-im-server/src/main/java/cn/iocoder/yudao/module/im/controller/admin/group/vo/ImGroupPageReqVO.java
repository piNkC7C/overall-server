package cn.iocoder.yudao.module.im.controller.admin.group.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Group page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ImGroupPageReqVO extends PageParam {

    @Schema(description = "Group name", example = "Overall.")
    private String name;

    @Schema(description = "Group Owner user ID.", example = "31460")
    private Long ownerUserId;

    @Schema(description = "Group announcement.")
    private String notice;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}