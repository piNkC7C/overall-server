package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.contract;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - HRM employeecontract response.")
@Data
public class HrmEmployeeContractRespVO {

    @Schema(description = "Contract code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long employeeId;

    @Schema(description = "Contract code.", example = "HT-2026-001")
    private String no;

    @Schema(description = "Contract type.", example = "1")
    private Integer type;

    @Schema(description = "Contract start Date.")
    private LocalDateTime startTime;

    @Schema(description = "Contract end Date.")
    private LocalDateTime endTime;

    @Schema(description = "Term.", example = "36")
    private Integer term;

    @Schema(description = "Contract status.", example = "1")
    private Integer status;

    @Schema(description = "Signing company.")
    private String signCompany;

    @Schema(description = "Contract sign date.")
    private LocalDateTime signTime;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Expiration reminder.", example = "true")
    private Boolean expireRemind;

    @Schema(description = "AttachmentAddressArray.")
    private List<String> fileUrls;

    @Schema(description = "Sort.", example = "1")
    private Integer sort;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
