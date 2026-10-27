package cn.iocoder.yudao.module.mes.controller.admin.home.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Schema(description = "MES home production trend response VO.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MesHomeProductionTrendRespVO {

    @Schema(description = "Date", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-04-05")
    private String date;

    @Schema(description = "Output quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1234")
    private BigDecimal quantity;

    @Schema(description = "Passed quantity quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1200")
    private BigDecimal qualifiedQuantity;

    @Schema(description = "Defect quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "34")
    private BigDecimal unqualifiedQuantity;

}
