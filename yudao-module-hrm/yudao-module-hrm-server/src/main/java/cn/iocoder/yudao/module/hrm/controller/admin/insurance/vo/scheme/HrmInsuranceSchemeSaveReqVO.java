package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.scheme;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.insurance.config.HrmInsuranceSchemeTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - HRM social security plan save request.")
@Data
public class HrmInsuranceSchemeSaveReqVO {

    @Schema(description = "Social security plan code.", example = "1024")
    private Long id;

    @Schema(description = "Plan name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Standard benefits plan")
    @NotBlank(message = "Plan name is required.")
    @Size(max = 64, message = "Plan name cannot exceed 64 characters.")
    private String name;

    @Schema(description = "Insurance region ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "440300")
    @NotNull(message = "Insurance City is required.")
    private Integer areaId;

    @Schema(description = "Household type.", example = "Local resident")
    @Size(max = 64, message = "Household type cannot exceed 64 characters.")
    private String householdType;

    @Schema(description = "Plan type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Plan type is required.")
    @InEnum(value = HrmInsuranceSchemeTypeEnum.class, message = "Plan type must be {value}.")
    private Integer type;

    @Schema(description = "Social security item list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Social security item is required.")
    private List<@NotNull(message = "Social security item is required.") @Valid HrmInsuranceSchemeProjectSaveReqVO> projectList;

}
