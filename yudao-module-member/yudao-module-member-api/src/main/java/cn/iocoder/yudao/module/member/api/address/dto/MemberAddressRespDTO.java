package cn.iocoder.yudao.module.member.api.address.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "RPC - usershipping address Response DTO.")
@Data
public class MemberAddressRespDTO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long userId;

    @Schema(description = "Recipient name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

    @Schema(description = "Phone number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300")
    private String mobile;

    @Schema(description = "Region ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "2666")
    private Integer areaId;

    @Schema(description = "Detailed shipping address.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Yudao 88 Community No. 106")
    private String detailAddress;

    @Schema(description = "Is not default.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean defaultStatus;

}
