package cn.iocoder.yudao.module.member.api.level.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "RPC service - member level Response DTO.")
@Data
public class MemberLevelRespDTO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Level name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Regular member")
    private String name;

    @Schema(description = "Level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer level;

    @Schema(description = "Upgrade experience.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer experience;

    @Schema(description = "Discount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer discountPercent;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status; // See CommonStatusEnum enum

}
