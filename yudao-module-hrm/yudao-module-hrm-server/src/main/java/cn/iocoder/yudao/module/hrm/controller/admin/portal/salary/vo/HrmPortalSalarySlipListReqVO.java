package cn.iocoder.yudao.module.hrm.controller.admin.portal.salary.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Schema(description = "HRM employee payslip list request VO.")
@Data
public class HrmPortalSalarySlipListReqVO {

    @Schema(description = "Start Month.", example = "2026-01")
    @Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])", message = "Start Month format must is yyyy-MM.")
    private String startMonth;

    @Schema(description = "End Month.", example = "2026-12")
    @Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])", message = "End Month format must is yyyy-MM.")
    private String endMonth;

    @Schema(description = "Sort type.", example = "1")
    @Range(min = 1, max = 2, message = "Sort type must be between 1 and 2.")
    private Integer orderType;

    @Schema(description = "Sort Direction.", example = "1")
    @Range(min = 1, max = 2, message = "Sort direction must be between 1 and 2.")
    private Integer order;

}
