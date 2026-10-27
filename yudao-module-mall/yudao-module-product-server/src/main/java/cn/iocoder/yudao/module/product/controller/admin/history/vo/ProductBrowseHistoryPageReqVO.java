package cn.iocoder.yudao.module.product.controller.admin.history.vo;

import cn.iocoder.yudao.framework.common.pojo.SortablePageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - productViewsrecordpage request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductBrowseHistoryPageReqVO extends SortablePageParam {

    @Schema(description = "User ID.", example = "4314")
    private Long userId;

    @Schema(description = "User is not delete.", example = "false")
    private Boolean userDeleted;

    @Schema(description = "Product SPU code.", example = "42")
    private Long spuId;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}