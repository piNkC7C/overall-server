package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.standard;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "HRM Standard benefits item list request VO.")
@Data
public class HrmInsuranceStandardProjectListReqVO {

    @Schema(description = "Insurance region ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "440300")
    @NotNull(message = "Insurance City is required.")
    private Integer areaId;

    @Schema(description = "Insurance plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "SS100173")
    @NotBlank(message = "Insurance plan code is required.")
    private String typeCode;

}
