package cn.iocoder.yudao.module.mp.controller.admin.account.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - Official Account account simple info response.")
@Data
public class MpAccountSimpleRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Official Account name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

}
