package cn.iocoder.yudao.module.mes.controller.admin.wm.itemconsume.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "MES material consumption line response VO.")
@Data
public class MesWmItemConsumeLineRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Consumption record ID.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long consumeId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long itemId;

    @Schema(description = "Consumed quantity.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal quantity;

    @Schema(description = "Lot code.")
    private Long batchId;

    @Schema(description = "Lot no.")
    private String batchCode;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

    // ==================== relation info ====================

    @Schema(description = "Material Code")
    private String itemCode;

    @Schema(description = "Material Name")
    private String itemName;

    @Schema(description = "Spec / Model")
    private String specification;

    @Schema(description = "Order characters.")
    private String unitName;

}
