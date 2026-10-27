package cn.iocoder.yudao.module.oa.controller.admin.discussion.vo.discussion;

import cn.iocoder.yudao.framework.common.pojo.SortablePageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.discussion.OaDiscussionTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "OA discussion page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaDiscussionPageReqVO extends SortablePageParam {

    @Schema(description = "Title.", example = "Product plan discussion")
    private String title;

    @Schema(description = "Discussion Type", example = "1")
    @InEnum(value = OaDiscussionTypeEnum.class, message = "Discussion Type must be {value}.")
    private Integer type;

    @Schema(description = "Publisher user ID.", example = "1")
    private Long userId;

    @Schema(description = "Create time range.", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
