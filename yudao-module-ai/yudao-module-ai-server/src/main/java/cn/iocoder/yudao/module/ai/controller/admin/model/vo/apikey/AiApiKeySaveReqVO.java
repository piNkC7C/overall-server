package cn.iocoder.yudao.module.ai.controller.admin.model.vo.apikey;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - AI API 密钥新增/修改 Request VO")
@Data
public class AiApiKeySaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "23538")
    private Long id;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Ernie")
    @NotEmpty(message = "Name is required.")
    private String name;

    @Schema(description = "密钥", requiredMode = Schema.RequiredMode.REQUIRED, example = "ABC")
    @NotEmpty(message = "Secret is required.")
    private String apiKey;

    @Schema(description = "平台", requiredMode = Schema.RequiredMode.REQUIRED, example = "OpenAI")
    @NotEmpty(message = "Platform is required.")
    private String platform;

    @Schema(description = "自定义 API 地址", example = "https://aip.baidubce.com")
    private String url;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    private Integer status;

}