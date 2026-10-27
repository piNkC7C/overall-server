package cn.iocoder.yudao.module.crm.controller.admin.receivable.vo.plan;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - CRM collectionplan create / edit request.")
@Data
public class CrmReceivablePlanSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Long id;

    @Schema(description = "Customer code.", hidden = true, example = "2")
    private Long customerId; // 该字段不通过前端传递，而是 contractId 查询出来设置进去

    @Schema(description = "Contract code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Contract code is required.")
    private Long contractId;

    @Schema(description = "Owner person code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Owner person code is required.")
    private Long ownerUserId;

    @Schema(description = "PlancollectionDate.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-02-02")
    @NotNull(message = "PlancollectionDate is required.")
    private LocalDateTime returnTime;

    @Schema(description = "Collection method.", example = "1")
    private Integer returnType;

    @Schema(description = "Plancollection amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "9000")
    @NotNull(message = "Plancollection amount is required.")
    private BigDecimal price;

    @Schema(description = "Remind Days Ahead", example = "1")
    private Integer remindDays;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
