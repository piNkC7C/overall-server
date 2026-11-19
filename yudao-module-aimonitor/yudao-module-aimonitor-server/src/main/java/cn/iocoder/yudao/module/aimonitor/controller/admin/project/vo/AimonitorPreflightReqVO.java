package cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Schema(description = "管理后台 - AI 监测品牌预检 Request VO")
@Data
public class AimonitorPreflightReqVO {

    @Schema(description = "官网", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.apple.com/")
    @NotBlank(message = "Website is required.")
    private String url;

    @Schema(description = "品牌名称", example = "Apple")
    private String brandName;

    @Schema(description = "国家代码", example = "US")
    private String country;

}
