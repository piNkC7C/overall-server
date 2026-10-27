package cn.iocoder.yudao.module.promotion.controller.admin.combination.vo.recrod;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - group buy record info Stats response.")
@Data
public class CombinationRecordSummaryVO {

    @Schema(description = "All group-buy records.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userCount;

    @Schema(description = "Successful group-buy records.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long successCount;

    @Schema(description = "Virtual group buyrecord.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long virtualGroupCount;

}
