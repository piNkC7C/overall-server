package cn.iocoder.yudao.module.ai.controller.admin.model.vo.model;

import cn.iocoder.yudao.module.ai.enums.model.AiModelTypeEnum;
import cn.iocoder.yudao.module.ai.enums.model.AiPlatformEnum;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - API 模型新增/修改 Request VO")
@Data
public class AiModelSaveReqVO {

    @Schema(description = "编号", example = "2630")
    private Long id;

    @Schema(description = "API 秘钥编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "22042")
    @NotNull(message = "API key ID cannot be empty.")
    private Long keyId;

    @Schema(description = "模型名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    @NotEmpty(message = "Model name is required.")
    private String name;

    @Schema(description = "模型标识", requiredMode = Schema.RequiredMode.REQUIRED, example = "gpt-3.5-turbo-0125")
    @NotEmpty(message = "Model key is required.")
    private String model;

    @Schema(description = "模型平台", requiredMode = Schema.RequiredMode.REQUIRED, example = "OpenAI")
    @NotEmpty(message = "ModelPlatform is required.")
    @InEnum(AiPlatformEnum.class)
    private String platform;

    @Schema(description = "模型类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Model type is required.")
    @InEnum(AiModelTypeEnum.class)
    private Integer type;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(CommonStatusEnum.class)
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "温度参数", example = "1")
    private Double temperature;

    @Schema(description = "单条回复的最大 Token 数量", example = "4096")
    private Integer maxTokens;

    @Schema(description = "上下文的最大 Message 数量", example = "8192")
    private Integer maxContexts;

}