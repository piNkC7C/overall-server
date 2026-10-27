package cn.iocoder.yudao.module.mes.controller.admin.wm.returnissue.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES production material return order line response.")
@Data
public class MesWmReturnIssueLineRespVO {

    @Schema(description = "Line ID.", example = "1")
    private Long id;

    @Schema(description = "Material return order ID.", example = "1")
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

    @Schema(description = "Inventoryrecord ID.", example = "1")
    private Long materialStockId;

    @Schema(description = "Material return quantity.", example = "100.00")
    private BigDecimal quantity;

    @Schema(description = "Lot ID.", example = "1")
    private Long batchId;

    @Schema(description = "Lot code.", example = "BAT202601001")
    private String batchCode;

    @Schema(description = "Is not need to need quality inspection.", example = "false")
    private Boolean rqcCheckFlag;

    @Schema(description = "Quality status.", example = "0")
    private Integer qualityStatus;

    @Schema(description = "Return inspection ID.", example = "21601")
    private Long rqcId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
