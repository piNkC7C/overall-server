package cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - AI 监测项目 Response VO")
@Data
public class AimonitorProjectRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "算法项目 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "pr_xxx")
    private String algorithmProjectId;

    @Schema(description = "项目名称", example = "Apple")
    private String name;

    @Schema(description = "品牌名称", example = "Apple")
    private String brandName;

    @Schema(description = "官网", example = "https://www.apple.com/")
    private String website;

    @Schema(description = "国家代码", example = "US")
    private String country;

    @Schema(description = "状态", example = "active")
    private String status;

    @Schema(description = "监测平台", example = "chatgpt,gemini,google_aio")
    private String platforms;

    @Schema(description = "品类")
    private String category;

    @Schema(description = "生意类型", example = "b2c")
    private String businessType;

    @Schema(description = "扫描次数", example = "3")
    private Integer scanCount;

    @Schema(description = "最近扫描时间")
    private LocalDateTime lastScanAt;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

}
