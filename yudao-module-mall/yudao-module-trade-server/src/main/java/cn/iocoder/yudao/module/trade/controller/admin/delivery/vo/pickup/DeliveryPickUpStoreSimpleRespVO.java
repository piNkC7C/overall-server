package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.pickup;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Schema(description = "Admin - Pickup Store simple info response.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryPickUpStoreSimpleRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23128")
    private Long id;

    @Schema(description = "Store Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    private String name;

    @Schema(description = "Store Phone", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601892312")
    private String phone;

    @Schema(description = "Region code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "18733")
    private Integer areaId;

    @Schema(description = "Region name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "xx City")
    private String areaName;

    @Schema(description = "Store street address.", requiredMode = Schema.RequiredMode.REQUIRED, example = "188 Fudan University Rd")
    private String detailAddress;

    @Schema(description = "Bound user ID group count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23128")
    private List<Long> verifyUserIds;

}
