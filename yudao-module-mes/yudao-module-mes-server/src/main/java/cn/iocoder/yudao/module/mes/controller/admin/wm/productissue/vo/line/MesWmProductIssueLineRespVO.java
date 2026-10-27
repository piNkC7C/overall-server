package cn.iocoder.yudao.module.mes.controller.admin.wm.productissue.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES material issue outbound order line response.")
@Data
public class MesWmProductIssueLineRespVO {

    @Schema(description = "Line ID.", example = "1")
    private Long id;

    @Schema(description = "Material issue order ID.", example = "1")
    private Long issueId;

    @Schema(description = "Material ID.", example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "M001")
    private String itemCode;

    @Schema(description = "Material name.", example = "Steel plate.")
    private String itemName;

    @Schema(description = "Spec / Model", example = "10mm*100mm")
    private String specification;

    @Schema(description = "Unit of measure name.", example = "Kg.")
    private String unitMeasureName;

    @Schema(description = "Material issue quantity.", example = "100.00")
    private BigDecimal quantity;

    @Schema(description = "LotID.", example = "1")
    private Long batchId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
