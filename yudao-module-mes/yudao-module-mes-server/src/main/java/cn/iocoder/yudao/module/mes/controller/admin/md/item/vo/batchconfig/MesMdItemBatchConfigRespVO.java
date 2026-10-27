package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.batchconfig;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES material lot attribute setting response.")
@Data
public class MesMdItemBatchConfigRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "69")
    private Long itemId;

    @Schema(description = "Lot attribute - production date.", example = "true")
    private Boolean produceDateFlag;

    @Schema(description = "Lot attribute - expiration date.", example = "true")
    private Boolean expireDateFlag;

    @Schema(description = "Lot attribute - inbound date.", example = "false")
    private Boolean receiptDateFlag;

    @Schema(description = "Lot attribute -supplier.", example = "false")
    private Boolean vendorFlag;

    @Schema(description = "Lot attribute -customer.", example = "false")
    private Boolean clientFlag;

    @Schema(description = "Lot attribute - sales order code.", example = "false")
    private Boolean salesOrderCodeFlag;

    @Schema(description = "Lot attribute - purchase order code.", example = "false")
    private Boolean purchaseOrderCodeFlag;

    @Schema(description = "Lot attribute -production work order.", example = "false")
    private Boolean workorderFlag;

    @Schema(description = "Lot attribute - production task.", example = "false")
    private Boolean taskFlag;

    @Schema(description = "Lot attribute -workstation.", example = "false")
    private Boolean workstationFlag;

    @Schema(description = "Lot attribute -tool.", example = "false")
    private Boolean toolFlag;

    @Schema(description = "Lot attribute - mold.", example = "false")
    private Boolean moldFlag;

    @Schema(description = "Lot attribute - production lot.", example = "true")
    private Boolean lotNumberFlag;

    @Schema(description = "Lot attribute - quality status.", example = "false")
    private Boolean qualityStatusFlag;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
