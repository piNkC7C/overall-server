package cn.iocoder.yudao.module.mp.controller.admin.material.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Official account media upload result response VO.")
@Data
public class MpMaterialUploadRespVO {

    @Schema(description = "Media media_id.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123")
    private String mediaId;

    @Schema(description = "Media URL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.png")
    private String url;

}
