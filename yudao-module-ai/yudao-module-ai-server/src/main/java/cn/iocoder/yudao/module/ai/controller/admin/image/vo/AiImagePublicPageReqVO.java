package cn.iocoder.yudao.module.ai.controller.admin.image.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "AI public image page request VO.")
@Data
public class AiImagePublicPageReqVO extends PageParam {

    @Schema(description = "Prompt")
    private String prompt;

}