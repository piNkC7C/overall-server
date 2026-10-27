package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.standard;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "HRM Standard benefits type response VO.")
@Data
public class HrmInsuranceStandardTypeRespVO {

    @Schema(description = "Insurance plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "SS100173")
    private String code;

    @Schema(description = "Insurance plan name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Local tier-1 residence")
    private String name;

}
