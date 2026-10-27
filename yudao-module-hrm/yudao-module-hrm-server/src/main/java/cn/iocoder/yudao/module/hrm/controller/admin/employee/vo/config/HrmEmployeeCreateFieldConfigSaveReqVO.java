package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.config;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeEntryStatusEnum;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Schema(description = "HRM new-employee field setting save request VO.")
@Data
public class HrmEmployeeCreateFieldConfigSaveReqVO {

    @Schema(description = "Onboarding status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Onboarding status is required.")
    @InEnum(value = HrmEmployeeEntryStatusEnum.class, message = "Onboarding status must be {value}.")
    @Range(min = 1, max = 2, message = "Onboarding status must be 1 or 2.")
    @DiffLogField(name = "Onboarding status.")
    private Integer entryStatus;

    @Schema(description = "Fieldsetting list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Fieldsetting list is required.")
    @DiffLogField(name = "Fieldsetting.")
    private List<HrmEmployeeFieldConfigSaveReqVO> fields;

}
