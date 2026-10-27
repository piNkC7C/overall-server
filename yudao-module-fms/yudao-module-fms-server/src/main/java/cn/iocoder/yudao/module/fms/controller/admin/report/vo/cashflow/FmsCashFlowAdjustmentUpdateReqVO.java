package cn.iocoder.yudao.module.fms.controller.admin.report.vo.cashflow;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "Cash-flow support update request VO.")
@Data
public class FmsCashFlowAdjustmentUpdateReqVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Auxiliary items.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Auxiliary items cannot be empty.")
    @Valid
    private List<Item> items = new ArrayList<>();

    @Schema(description = "Cash-flow support update item request VO.")
    @Data
    public static class Item {

        @Schema(description = "Data code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Data code is required.")
        private Long id;

        @Schema(description = "Period amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Period amount cannot be empty.")
        private BigDecimal currentAmount;

        @Schema(description = "YTD amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200.00")
        @NotNull(message = "YTD amount cannot be empty.")
        private BigDecimal yearAmount;

    }

}
