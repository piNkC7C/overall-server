package cn.iocoder.yudao.module.oa.controller.admin.seal.vo.apply;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Seal request page request VO.")
public class OaSealApplyPageReqVO extends PageParam {

    @Schema(description = "Apply please order no.", example = "SEAL-APPLY-001")
    private String no;

    @Schema(description = "Seal No.", example = "1024")
    private Long sealId;

    @Schema(description = "Seal Name", example = "Company seal")
    private String sealName;

    @Schema(description = "Apply please department code.", example = "100")
    private Long deptId;

    @Schema(description = "Create time range.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "Planned Seal TimeRange.", example = "[\"2026-09-11 09:00:00\", \"2026-09-11 18:00:00\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] expectedUseTime;

    @Schema(description = "Approval status.", example = "-1")
    private Integer status;

    @Schema(description = "Seal status.", example = "0")
    private Integer useStatus;

    @Schema(description = "Seal-use type.", example = "1")
    private Integer type;

    @Schema(description = "Seal-use method.", example = "1")
    private Integer mode;

    @Schema(description = "Urgent", example = "false")
    private Boolean urgent;
}
