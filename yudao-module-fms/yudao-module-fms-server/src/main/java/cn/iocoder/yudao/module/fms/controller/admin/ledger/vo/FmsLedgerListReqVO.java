package cn.iocoder.yudao.module.fms.controller.admin.ledger.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(description = "管理后台 - FMS 账簿列表查询 Request VO")
@Data
public class FmsLedgerListReqVO {

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "开始会计期间", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-08")
    @NotNull(message = "Start Accounting Period is required.")
    @Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])", message = "Start Accounting Period format is invalid.")
    private String startMonth;

    @Schema(description = "结束会计期间", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-12")
    @NotNull(message = "End Accounting Period is required.")
    @Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])", message = "End Accounting Period format is invalid.")
    private String endMonth;

    @Schema(description = "科目编号", example = "1024")
    private Long subjectId;

    @Schema(description = "起始科目编号", example = "1024")
    private Long startSubjectId;

    @Schema(description = "结束科目编号", example = "2048")
    private Long endSubjectId;

    @Schema(description = "最小科目级次", example = "1")
    @Min(value = 1, message = "Minimum account level cannot be less than 1.")
    @Max(value = 10, message = "Minimum account level cannot be greater than 10.")
    private Integer minLevel;

    @Schema(description = "最大科目级次", example = "4")
    @Min(value = 1, message = "Maximum account level cannot be less than 1.")
    @Max(value = 10, message = "Maximum account level cannot be greater than 10.")
    private Integer maxLevel;

}
