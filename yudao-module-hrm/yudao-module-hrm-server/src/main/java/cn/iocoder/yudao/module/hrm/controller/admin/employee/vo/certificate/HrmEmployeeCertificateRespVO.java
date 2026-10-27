package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.certificate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - HRM employeeCertificate response.")
@Data
public class HrmEmployeeCertificateRespVO {

    @Schema(description = "Certificate code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long employeeId;

    @Schema(description = "Certificate name.", example = "Senior engineer")
    private String name;

    @Schema(description = "Certificate level.", example = "Senior")
    private String level;

    @Schema(description = "Certificate code.", example = "CERT-001")
    private String no;

    @Schema(description = "Valid from.")
    private LocalDateTime startTime;

    @Schema(description = "Valid to.")
    private LocalDateTime endTime;

    @Schema(description = "Issuer", example = "Labor bureau")
    private String issuingAuthority;

    @Schema(description = "Issue Date")
    private LocalDateTime issuingTime;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Sort.", example = "1")
    private Integer sort;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
