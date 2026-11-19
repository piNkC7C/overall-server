package cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "管理后台 - AI 监测项目创建 Request VO（转发算法 POST /api/projects）")
@Data
public class AimonitorProjectCreateReqVO {

    @Schema(description = "品牌名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Apple")
    @NotBlank(message = "Brand name is required.")
    private String brandName;

    @Schema(description = "官网", example = "https://www.apple.com/")
    private String website;

    @Schema(description = "监测关键词")
    private List<String> keywords;

    @Schema(description = "问题来源：site / keywords", example = "site")
    private String promptSource;

    @Schema(description = "国家代码", example = "US")
    private String country;

    @Schema(description = "监测平台", example = "[\"chatgpt\",\"gemini\",\"google_aio\"]")
    private List<String> platforms;

    @Schema(description = "品类")
    private String category;

    @Schema(description = "生意类型", example = "b2c")
    private String businessType;

    @Schema(description = "服务区域")
    private String serviceArea;

    @Schema(description = "预检确认的商家资料")
    private Map<String, Object> merchantProfile;

    @Schema(description = "竞品列表")
    private List<String> seedCompetitors;

    @Schema(description = "预检识别关键词")
    private List<String> detectedKeywords;

    @Schema(description = "每个方向问题数", example = "3")
    private Integer promptsPerDirection;

    @Schema(description = "创建后是否立即扫描", example = "true")
    private Boolean startScan;

    @Schema(description = "备注")
    private String remark;

}
