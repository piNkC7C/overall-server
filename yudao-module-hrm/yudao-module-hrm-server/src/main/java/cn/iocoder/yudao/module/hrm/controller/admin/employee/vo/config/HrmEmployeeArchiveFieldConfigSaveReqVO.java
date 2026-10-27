package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.config;

import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - HRM employee profile fieldsetting save request.")
@Data
public class HrmEmployeeArchiveFieldConfigSaveReqVO {

    @Schema(description = "Fieldsetting list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Fieldsetting list is required.")
    @DiffLogField(name = "Fieldsetting.")
    private List<HrmEmployeeFieldConfigSaveReqVO> fields;

}
