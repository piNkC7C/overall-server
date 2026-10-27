package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.certificate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.isAfterOrEqual;

@Schema(description = "Admin - HRM employeeCertificate save request.")
@Data
public class HrmEmployeeCertificateSaveReqVO {

    @Schema(description = "Certificate code.", example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "Certificate name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Senior engineer")
    @NotBlank(message = "Certificate name is required.")
    @Size(max = 255, message = "Certificate name length cannot exceed 255 characters.")
    @DiffLogField(name = "Certificate name.")
    private String name;

    @Schema(description = "Certificate level.", example = "Senior")
    @Size(max = 255, message = "Certificate level length cannot exceed 255 characters.")
    @DiffLogField(name = "Certificate level.")
    private String level;

    @Schema(description = "Certificate code.", example = "CERT-001")
    @Size(max = 255, message = "Certificate code length cannot exceed 255 characters.")
    @DiffLogField(name = "Certificate code.")
    private String no;

    @Schema(description = "Valid from.")
    @DiffLogField(name = "Valid From")
    private LocalDateTime startTime;

    @Schema(description = "Valid to.")
    @DiffLogField(name = "Valid To")
    private LocalDateTime endTime;

    @Schema(description = "Issuer", example = "Labor bureau")
    @Size(max = 255, message = "Issuer length cannot exceed 255 characters.")
    @DiffLogField(name = "Issuer")
    private String issuingAuthority;

    @Schema(description = "Issue Date")
    @DiffLogField(name = "Issue Date")
    private LocalDateTime issuingTime;

    @Schema(description = "Notes.", example = "Professional qualification certificate")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    @DiffLogField(name = "Notes.")
    private String remark;

    @Schema(description = "Sort.", example = "1")
    @DiffLogField(name = "Sort.")
    private Integer sort;

    @AssertTrue(message = "Certificate expiration date end Date cannot earlier than start Date.")
    @JsonIgnore
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || isAfterOrEqual(endTime, startTime);
    }

}
