package cn.iocoder.yudao.module.oa.controller.admin.supply.vo.issue;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.module.oa.enums.supply.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Issue record page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaSupplyIssuePageReqVO extends PageParam {

    @Schema(description = "Item Name", example = "A4 paper")
    private String itemName;

    @Schema(description = "Apply please person.", example = "John.")
    private String creatorName;

    @Schema(description = "Admin type.", example = "1")
    private Integer manageType;

    @Schema(description = "Used type.", example = "1")
    private Integer useType;

    @Schema(description = "Detail status.", example = "0")
    private Integer status;

    @Schema(description = "Apply please time.", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
