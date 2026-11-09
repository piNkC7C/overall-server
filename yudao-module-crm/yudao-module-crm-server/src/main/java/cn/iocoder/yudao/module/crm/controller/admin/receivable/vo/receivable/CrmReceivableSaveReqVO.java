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

@Schema(description = "管理后台 - CRM 回款新增/修改 Request VO")
@Data
public class CrmReceivableSaveReqVO {

    @Schema(description = "编号", example = "25787")
    private Long id;

    @Schema(description = "负责人编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @DiffLogField(name = "负责人", function = SysAdminUserParseFunction.NAME)
    @NotNull(message = "Owner person code is required.")
    private Long ownerUserId;

    @Schema(description = "客户编号", example = "2")
    @DiffLogField(name = "客户", function = CrmCustomerParseFunction.NAME)
    private Long customerId; // 该字段不通过前端传递，而是 contractId 查询出来设置进去

    @Schema(description = "合同编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @DiffLogField(name = "合同", function = CrmContractParseFunction.NAME)
    @NotNull(message = "Contract code is required.")
    private Long contractId;

    @Schema(description = "回款计划编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @DiffLogField(name = "合同", function = CrmReceivablePlanParseFunction.NAME)
    private Long planId;

    @Schema(description = "回款方式", example = "2")
    @DiffLogField(name = "回款方式", function = CrmReceivableReturnTypeParseFunction.NAME)
    @InEnum(CrmReceivableReturnTypeEnum.class)
    private Integer returnType;

    @Schema(description = "回款金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "9000")
    @DiffLogField(name = "回款金额")
    @NotNull(message = "Collection amount is required.")
    private BigDecimal price;

    @Schema(description = "回款日期", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-02-02")
    @NotNull(message = "CollectionDate is required.")
    @DiffLogField(name = "回款日期")
    private LocalDateTime returnTime;

    @Schema(description = "备注", example = "Notes.")
    @DiffLogField(name = "备注")
    private String remark;

}
