package cn.iocoder.yudao.module.crm.controller.admin.customer.vo.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - CRM 销售简报 Response VO")
@Data
public class CrmSalesBriefingRespVO {

    @Schema(description = "今日新增客户数", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long customerCount;

    @Schema(description = "今日新增联系人数", requiredMode = Schema.RequiredMode.REQUIRED, example = "8")
    private Long contactCount;

    @Schema(description = "今日新增商机数", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Long businessCount;

    @Schema(description = "今日新增合同数", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Long contractCount;

    @Schema(description = "今日合同金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000.00")
    private BigDecimal contractPrice;

    @Schema(description = "今日回款金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "5000.00")
    private BigDecimal receivablePrice;

    @Schema(description = "今日新增线索数", requiredMode = Schema.RequiredMode.REQUIRED, example = "12")
    private Long clueCount;

    @Schema(description = "今日新增跟进数", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Long followUpCount;

}
