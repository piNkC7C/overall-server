package cn.iocoder.yudao.module.oa.controller.admin.seal.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - Seal page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaSealPageReqVO extends PageParam {

    @Schema(description = "Code.", example = "SEAL-001")
    private String no;

    @Schema(description = "Name.", example = "Company seal")
    private String name;

    @Schema(description = "Category.", example = "1")
    private Integer category;

    @Schema(description = "Type.", example = "1")
    private Integer type;

    @Schema(description = "Custodian code.", example = "1024")
    private Long keeperUserId;

    @Schema(description = "Department code.", example = "1024")
    private Long deptId;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Purchase TimeRange.", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] purchaseTime;

    @Schema(description = "Enabled time range.", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] enableTime;

    @Schema(description = "Disable time range.", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] disableTime;

}
