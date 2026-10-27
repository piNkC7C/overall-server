package cn.iocoder.yudao.module.mes.controller.admin.wm.returnsales.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 管理后台 - MES 销售退货相关
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - MES sales return line response.")
@Data
public class MesWmReturnSalesLineRespVO {

    @Schema(description = "Line ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Return orderID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long returnId;

    @Schema(description = "Material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "M001")
    private String itemCode;

    @Schema(description = "Material name.", example = "Material A.")
    private String itemName;

    @Schema(description = "Material SKU.", example = "100*200")
    private String itemSpecification;

    @Schema(description = "Unit of measure.", example = "")
    private String itemUnit;

    @Schema(description = "Return quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    private BigDecimal quantity;

    @Schema(description = "LotID.", example = "1")
    private Long batchId;

    @Schema(description = "Return inspection ID.", example = "400")
    private Long rqcId;

    @Schema(description = "Is not need to need quality inspection.", example = "true")
    private Boolean rqcCheckFlag;

    @Schema(description = "Lot no.", example = "B001")
    private String batchCode;

    @Schema(description = "Quality status.", example = "Passed")
    private Integer qualityStatus;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
