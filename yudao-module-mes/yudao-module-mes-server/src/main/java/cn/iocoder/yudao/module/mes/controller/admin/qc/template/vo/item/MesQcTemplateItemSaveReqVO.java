package cn.iocoder.yudao.module.mes.controller.admin.qc.template.vo.item;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES quality inspection plan -product relation create / edit request.")
@Data
public class MesQcTemplateItemSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Quality inspection plan ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Quality inspection plan ID is required.")
    private Long templateId;

    @Schema(description = "Product material ID ( relation mes_md_item).", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Product material ID is required.")
    private Long itemId;

    @Schema(description = "Minimum inspection count.", example = "5")
    private Integer quantityCheck;

    @Schema(description = "Maximum failed count.", example = "0")
    private Integer quantityUnqualified;

    @Schema(description = "MaximumCritical Defect Rate (%).", example = "0")
    private BigDecimal criticalRate;

    @Schema(description = "MaximumMajor Defect Rate (%).", example = "0")
    private BigDecimal majorRate;

    @Schema(description = "MaximumMinor Defect Rate (%).", example = "100")
    private BigDecimal minorRate;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
