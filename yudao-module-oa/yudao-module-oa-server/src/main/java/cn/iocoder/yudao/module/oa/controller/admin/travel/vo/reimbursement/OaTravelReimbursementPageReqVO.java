package cn.iocoder.yudao.module.oa.controller.admin.travel.vo.reimbursement;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Travel expense page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaTravelReimbursementPageReqVO extends PageParam {

    @Schema(description = "Document code.", example = "CLBX202609140001")
    private String no;

    @Schema(description = "Approval status.", example = "-1")
    private Integer status;

    @Schema(description = "Apply please department code.", example = "1024")
    private Long deptId;

    @Schema(description = "Create time.", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "Payment status.", example = "false")
    private Boolean payStatus;


}
