package cn.iocoder.yudao.module.mes.controller.admin.qc.indicatorresult.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - MES inspection result response.")
@Data
public class MesQcIndicatorResultRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Sample ID.", example = "SPL-001")
    private String code;

    @Schema(description = "Relation quality inspection order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long qcId;

    @Schema(description = "Quality inspection type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer qcType;

    @Schema(description = "Product material ID.", example = "1")
    private Long itemId;

    @Schema(description = "Item SN.", example = "SN-001")
    private String sn;

    @Schema(description = "Notes.", example = "No.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    // ========== 子表：检验结果明细 ==========

    @Schema(description = "Inspection resultdetail list.")
    private List<Item> items;

    @Schema(description = "Inspection resultdetail item.")
    @Data
    public static class Item {

        @Schema(description = "Code.", example = "1024")
        private Long id;

        @Schema(description = "Relation inspection resultID.", example = "1")
        private Long resultId;

        @Schema(description = "Inspect metric ID.", example = "1")
        private Long indicatorId;

        @Schema(description = "Inspection value (stored as text).", example = "3.14")
        private String value;

        @Schema(description = "Notes.", example = "No.")
        private String remark;

        // ========== 关联查询字段（来自 indicator） ==========

        @Schema(description = "Inspect metric name.", example = "Appearance check")
        private String indicatorName;

        @Schema(description = "QC value type.", example = "1")
        private Integer valueType;

        @Schema(description = "ValueProperty.", example = "IMG")
        private String valueSpecification;

    }

}
