package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.monthrecord.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "HRM employee monthly benefits item update request VO.")
@Data
public class HrmInsuranceMonthEmployeeRecordUpdateReqVO {

    @Schema(description = "Employee monthly benefits ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employee social security record code is required.")
    private Long id;

    @Schema(description = "Social security plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Social security plan is required.")
    private Long schemeId;

    @Schema(description = "Social security item list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Social security item is required.")
    @Valid
    private List<HrmInsuranceMonthEmployeeProjectUpdateReqVO> projects;

}
