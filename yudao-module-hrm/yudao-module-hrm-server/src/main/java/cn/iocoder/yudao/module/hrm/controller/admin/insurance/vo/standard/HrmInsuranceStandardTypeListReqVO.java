package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.standard;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "HRM Standard benefits type list request VO.")
@Data
public class HrmInsuranceStandardTypeListReqVO {

    @Schema(description = "Insurance region ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "440300")
    @NotNull(message = "Insurance City is required.")
    private Integer areaId;

}
