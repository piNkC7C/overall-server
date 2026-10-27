package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.customer;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "CRM customer conversion analysis VO.")
@Data
public class CrmStatisticsCustomerContractSummaryRespVO {

    @Schema(description = "Customer name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String customerName;

    @Schema(description = "Contract name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Demo contract")
    private String contractName;

    @Schema(description = "Contract total.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1200.00")
    private BigDecimal totalPrice;

    @Schema(description = "Collection amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1200.00")
    private BigDecimal receivablePrice;

    @Schema(description = "Industry code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer industryId;

    @Schema(description = "Customer source code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer source;

    @Schema(description = "Owner person code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long ownerUserId;
    @Schema(description = "Owner person.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String ownerUserName;

    @Schema(description = "Creator code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private String creator;
    @Schema(description = "Creator.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Source")
    private String creatorUserName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-02-01 13:24:26")
    private LocalDateTime createTime;

    @Schema(description = "Order Date.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-02-02 00:00:00")
    private LocalDateTime orderDate;

}
