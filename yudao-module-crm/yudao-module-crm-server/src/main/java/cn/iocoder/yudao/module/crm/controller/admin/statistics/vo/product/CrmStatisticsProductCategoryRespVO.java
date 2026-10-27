package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Product-category sales analysis response VO.")
@Data
public class CrmStatisticsProductCategoryRespVO {

    @Schema(description = "Product category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long categoryId;

    @Schema(description = "Product category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Software")
    private String categoryName;

    @Schema(description = "Contract quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer contractCount;

    @Schema(description = "Sales quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private BigDecimal productCount;

    @Schema(description = "Sales amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20000.00")
    private BigDecimal productTotalPrice;

}
