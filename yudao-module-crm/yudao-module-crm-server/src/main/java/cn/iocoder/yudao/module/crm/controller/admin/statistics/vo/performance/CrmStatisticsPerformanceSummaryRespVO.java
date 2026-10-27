package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.performance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Employee contract-performance summary response VO.")
@Data
public class CrmStatisticsPerformanceSummaryRespVO {

    @Schema(description = "Timeline", requiredMode = Schema.RequiredMode.REQUIRED, example = "202401")
    private String time;

    @Schema(description = "Contract quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer contractCount;

    @Schema(description = "Contract amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000.00")
    private BigDecimal contractPrice;

    @Schema(description = "Collection amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8000.00")
    private BigDecimal receivablePrice;

    @Schema(description = "Not collection amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2000.00")
    private BigDecimal unreceivedPrice;

}
