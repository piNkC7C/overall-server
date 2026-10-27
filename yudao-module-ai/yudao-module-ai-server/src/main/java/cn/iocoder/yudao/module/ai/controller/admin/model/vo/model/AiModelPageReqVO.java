package cn.iocoder.yudao.module.ai.controller.admin.model.vo.model;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "Admin - API model page request.")
@Data
public class AiModelPageReqVO extends PageParam {

    @Schema(description = "Model name.", example = "John.")
    private String name;

    @Schema(description = "Model key.", example = "gpt-3.5-turbo-0125")
    private String model;

    @Schema(description = "ModelPlatform.", example = "OpenAI")
    private String platform;

}