package cn.iocoder.yudao.module.oa.controller.admin.supply.vo.apply;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.module.oa.enums.supply.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Supply requisition page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaSupplyApplyPageReqVO extends PageParam {

    @Schema(description = "Apply please order no.", example = "YC202609140001")
    private String no;

    @Schema(description = "Document status.", example = "-1")
    private Integer status;

    @Schema(description = "Apply please department code.", example = "1024")
    private Long deptId;

    @Schema(description = "Create time.", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
