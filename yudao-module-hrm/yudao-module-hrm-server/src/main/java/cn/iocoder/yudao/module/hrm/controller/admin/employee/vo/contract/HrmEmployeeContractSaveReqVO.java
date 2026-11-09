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

@Schema(description = "管理后台 - HRM 员工合同保存 Request VO")
@Data
public class HrmEmployeeContractSaveReqVO {

    @Schema(description = "合同编号", example = "1024")
    private Long id;

    @Schema(description = "员工编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "合同编号", example = "HT-2026-001")
    @Size(max = 128, message = "Contract code length cannot exceed 128 characters.")
    @DiffLogField(name = "合同编号")
    private String no;

    @Schema(description = "合同类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Contract type cannot be empty.")
    @InEnum(value = HrmEmployeeContractTypeEnum.class, message = "Contract type must be {value}.")
    @DiffLogField(name = "合同类型")
    private Integer type;

    @Schema(description = "合同开始日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Contract start Date is required.")
    @DiffLogField(name = "合同开始日期")
    private LocalDateTime startTime;

    @Schema(description = "合同结束日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Contract end Date is required.")
    @DiffLogField(name = "合同结束日期")
    private LocalDateTime endTime;

    @Schema(description = "期限，单位：年", example = "3")
    @Min(value = 1, message = "Contract term cannot be less than 1 year.")
    @Max(value = 10, message = "Contract term cannot exceed 10 years.")
    @DiffLogField(name = "合同期限")
    private Integer term;

    @Schema(description = "合同状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Contract status is required.")
    @InEnum(value = HrmEmployeeContractStatusEnum.class, message = "Contract status must be {value}.")
    @DiffLogField(name = "合同状态")
    private Integer status;

    @Schema(description = "签约公司", example = "Sample Tech LLC")
    @Size(max = 255, message = "Signing company cannot exceed 255 characters.")
    @DiffLogField(name = "签约公司")
    private String signCompany;

    @Schema(description = "合同签订日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Contract sign date cannot be empty.")
    @DiffLogField(name = "合同签订日期")
    private LocalDateTime signTime;

    @Schema(description = "备注", example = "First employment contract")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    @DiffLogField(name = "备注")
    private String remark;

    @Schema(description = "是否到期提醒", example = "true")
    @DiffLogField(name = "是否到期提醒")
    private Boolean expireRemind;

    @Schema(description = "附件地址数组", example = "[https://example.com/contract.pdf]")
    @DiffLogField(name = "附件")
    private List<String> fileUrls;

    @Schema(description = "排序", example = "1")
    @DiffLogField(name = "排序")
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
