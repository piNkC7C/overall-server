package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.pickup;

import cn.iocoder.yudao.module.trade.controller.admin.base.system.user.UserSimpleBaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - Pickup Store response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DeliveryPickUpStoreRespVO extends DeliveryPickUpStoreBaseVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23128")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Region name.", example = "Putuo District, Shanghai")
    private String areaName;

    @Schema(description = "Write-off users.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<UserSimpleBaseVO> verifyUsers;

}
