package cn.iocoder.yudao.module.fms.controller.admin.ledger.vo.multicolumn;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import cn.iocoder.yudao.module.fms.controller.admin.ledger.vo.detail.FmsLedgerDetailRespVO;

import java.util.List;

@Schema(description = "FMS multi-column ledger response VO.")
@Data
@Accessors(chain = true)
public class FmsLedgerMultiColumnRespVO {

    @Schema(description = "Dynamic account column.")
    private List<Column> columns;

    @Schema(description = "Ledger row.")
    private List<FmsLedgerDetailRespVO> rows;

    @Schema(description = "Multi-column ledger account column response VO.")
    @Data
    public static class Column {

        @Schema(description = "Account code.", example = "1024")
        private Long subjectId;

        @Schema(description = "Account code.", example = "560101")
        private String subjectCode;

        @Schema(description = "Account name.", example = "Office supply")
        private String subjectName;

        @Schema(description = "Balance Direction.", example = "1")
        private Integer balanceDirection;

    }

}
