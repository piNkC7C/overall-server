package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.contract;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.employment.HrmEmployeeContractStatusEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.employment.HrmEmployeeContractTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.isAfterOrEqual;

@Schema(description = "Admin - HRM employeecontract save request.")
@Data
public class HrmEmployeeContractSaveReqVO {

    @Schema(description = "Contract code.", example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "Contract code.", example = "HT-2026-001")
    @Size(max = 128, message = "Contract code length cannot exceed 128 characters.")
    @DiffLogField(name = "Contract code.")
    private String no;

    @Schema(description = "Contract type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Contract type cannot be empty.")
    @InEnum(value = HrmEmployeeContractTypeEnum.class, message = "Contract type must be {value}.")
    @DiffLogField(name = "Contract Type")
    private Integer type;

    @Schema(description = "Contract start Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Contract start Date is required.")
    @DiffLogField(name = "Contract start Date.")
    private LocalDateTime startTime;

    @Schema(description = "Contract end Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Contract end Date is required.")
    @DiffLogField(name = "Contract end Date.")
    private LocalDateTime endTime;

    @Schema(description = "Term, in years.", example = "3")
    @Min(value = 1, message = "Contract term cannot be less than 1 year.")
    @Max(value = 10, message = "Contract term cannot exceed 10 years.")
    @DiffLogField(name = "Contract Term")
    private Integer term;

    @Schema(description = "Contract status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Contract status is required.")
    @InEnum(value = HrmEmployeeContractStatusEnum.class, message = "Contract status must be {value}.")
    @DiffLogField(name = "Contract status.")
    private Integer status;

    @Schema(description = "Signing company.", example = "Sample Tech LLC")
    @Size(max = 255, message = "Signing company cannot exceed 255 characters.")
    @DiffLogField(name = "Contracting Company")
    private String signCompany;

    @Schema(description = "Contract sign date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Contract sign date cannot be empty.")
    @DiffLogField(name = "Contract Sign Date")
    private LocalDateTime signTime;

    @Schema(description = "Notes.", example = "First employment contract")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    @DiffLogField(name = "Notes.")
    private String remark;

    @Schema(description = "Expiration reminder.", example = "true")
    @DiffLogField(name = "Expiration Reminder")
    private Boolean expireRemind;

    @Schema(description = "AttachmentAddressArray.", example = "[https://example.com/contract.pdf]")
    @DiffLogField(name = "Attachment")
    private List<String> fileUrls;

    @Schema(description = "Sort.", example = "1")
    @DiffLogField(name = "Sort.")
    private Integer sort;

    @AssertTrue(message = "Contract end Date cannot earlier than start Date.")
    @JsonIgnore
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || isAfterOrEqual(endTime, startTime);
    }

    @AssertTrue(message = "Contract term cannot be empty.")
    @JsonIgnore
    public boolean isTermValid() {
        return type == null
                || HrmEmployeeContractTypeEnum.NON_FIXED_TERM_LABOR_CONTRACT.getType().equals(type)
                || term != null;
    }

}
