package cn.iocoder.yudao.module.mp.controller.admin.tag.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - Official Accounttag simple info response.")
@Data
public class MpTagSimpleRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Official Account tag code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long tagId;

    @Schema(description = "Tag name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Happy")
    private String name;

}
