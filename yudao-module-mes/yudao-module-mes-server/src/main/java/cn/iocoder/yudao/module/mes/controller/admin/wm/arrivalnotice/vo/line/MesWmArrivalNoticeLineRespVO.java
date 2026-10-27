package cn.iocoder.yudao.module.mes.controller.admin.wm.arrivalnotice.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES receiving notification order line response.")
@Data
public class MesWmArrivalNoticeLineRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Receiving notification order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long noticeId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "M001")
    private String itemCode;

    @Schema(description = "Material name.", example = "Steel plate.")
    private String itemName;

    @Schema(description = "Spec / Model", example = "10mm*100mm")
    private String specification;

    @Schema(description = "Unit of measure name.", example = "Kg.")
    private String unitMeasureName;

    @Schema(description = "Receiving quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "500.00")
    private BigDecimal arrivalQuantity;

    @Schema(description = "Passed quantity.", example = "500.00")
    private BigDecimal qualifiedQuantity;

    @Schema(description = "Require incoming inspection.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean iqcCheckFlag;

    @Schema(description = "Incoming inspection number.", example = "1")
    private Long iqcId;

    @Schema(description = "Incoming inspectioncode.", example = "IQC20260201")
    private String iqcCode;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
