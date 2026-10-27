package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Product sales response VO.")
@Data
public class CrmStatisticsProductSalesRespVO {

    @Schema(description = "Product category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long categoryId;

    @Schema(description = "Product category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Software")
    private String categoryName;

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Long productId;

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "CRM Professional")
    private String productName;

    @Schema(description = "Contract code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "30")
    private Long contractId;

    @Schema(description = "Contract code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "HT20240101001")
    private String contractNo;

    @Schema(description = "Contract name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "CRM purchase contract.")
    private String contractName;

    @Schema(description = "Owner person code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long ownerUserId;

    @Schema(description = "Owner person Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String ownerUserName;

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "40")
    private Long customerId;

    @Schema(description = "Customer name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test customer")
    private String customerName;

    @Schema(description = "Unit Price", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    private BigDecimal productPrice;

    @Schema(description = "Sales quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private BigDecimal productCount;

    @Schema(description = "Sales amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200.00")
    private BigDecimal productTotalPrice;

}
