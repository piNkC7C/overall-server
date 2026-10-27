package cn.iocoder.yudao.module.crm.controller.admin.receivable.vo.receivable;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.receivable.CrmReceivableReturnTypeEnum;
import cn.iocoder.yudao.module.crm.framework.operatelog.core.*;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - CRM collection create / edit request.")
@Data
public class CrmReceivableSaveReqVO {

    @Schema(description = "Code.", example = "25787")
    private Long id;

    @Schema(description = "Owner person code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @DiffLogField(name = "Owner person.", function = SysAdminUserParseFunction.NAME)
    @NotNull(message = "Owner person code is required.")
    private Long ownerUserId;

    @Schema(description = "Customer code.", example = "2")
    @DiffLogField(name = "Customer.", function = CrmCustomerParseFunction.NAME)
    private Long customerId; // 该字段不通过前端传递，而是 contractId 查询出来设置进去

    @Schema(description = "Contract code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @DiffLogField(name = "Contract.", function = CrmContractParseFunction.NAME)
    @NotNull(message = "Contract code is required.")
    private Long contractId;

    @Schema(description = "Collectionplan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @DiffLogField(name = "Contract.", function = CrmReceivablePlanParseFunction.NAME)
    private Long planId;

    @Schema(description = "Collection method.", example = "2")
    @DiffLogField(name = "Collection method.", function = CrmReceivableReturnTypeParseFunction.NAME)
    @InEnum(CrmReceivableReturnTypeEnum.class)
    private Integer returnType;

    @Schema(description = "Collection amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "9000")
    @DiffLogField(name = "Collection amount.")
    @NotNull(message = "Collection amount is required.")
    private BigDecimal price;

    @Schema(description = "CollectionDate.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-02-02")
    @NotNull(message = "CollectionDate is required.")
    @DiffLogField(name = "CollectionDate.")
    private LocalDateTime returnTime;

    @Schema(description = "Notes.", example = "Notes.")
    @DiffLogField(name = "Notes.")
    private String remark;

}
