package cn.iocoder.yudao.module.member.controller.admin.address.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "Admin - usershipping address response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AddressRespVO extends AddressBaseVO {

    @Schema(description = "Shipping-address ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7380")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Region name.", example = "Putuo District, Shanghai")
    private String areaName;

}
