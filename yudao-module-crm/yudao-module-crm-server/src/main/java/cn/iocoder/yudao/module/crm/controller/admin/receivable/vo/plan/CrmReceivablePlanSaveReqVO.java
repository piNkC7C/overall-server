package cn.iocoder.yudao.module.crm.controller.admin.receivable.vo.plan;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - CRM 回款计划新增/修改 Request VO")
@Data
public class CrmReceivablePlanSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Long id;

    @Schema(description = "客户编号", hidden = true, example = "2")
    private Long customerId; // 该字段不通过前端传递，而是 contractId 查询出来设置进去

    @Schema(description = "合同编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Contract code is required.")
    private Long contractId;

    @Schema(description = "负责人编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Owner person code is required.")
    private Long ownerUserId;

    @Schema(description = "计划回款日期", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-02-02")
    @NotNull(message = "PlancollectionDate is required.")
    private LocalDateTime returnTime;

    @Schema(description = "回款方式", example = "1")
    private Integer returnType;

    @Schema(description = "计划回款金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "9000")
    @NotNull(message = "Plancollection amount is required.")
    private BigDecimal price;

    @Schema(description = "提前几天提醒", example = "1")
    private Integer remindDays;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}
