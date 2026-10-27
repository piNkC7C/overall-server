package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.option;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "HRM payroll sheet pay item response VO.")
@Data
public class HrmSalaryOptionRespVO {

    @Schema(description = "Payroll item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Payroll item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10101")
    private Integer code;

    @Schema(description = "Parent payroll item code.", example = "10")
    private Integer parentCode;

    @Schema(description = "Payroll item name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Base salary")
    private String name;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Is not System default item.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean systemFlag;

    @Schema(description = "Payroll item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Taxable.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean taxEnabled;

    @Schema(description = "Is not Show.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean visible;

    @Schema(description = "Included in calculation.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean calculateEnabled;

    @Schema(description = "Is not Enabled.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean enabled;

    @Schema(description = "Standard payroll item directory code.", example = "1024")
    private Long templateId;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
