package cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - AI 监测项目更新 Request VO")
@Data
public class AimonitorProjectUpdateReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Id is required.")
    private Long id;

    @Schema(description = "项目名称")
    private String name;

    @Schema(description = "品牌名称")
    private String brandName;

    @Schema(description = "官网")
    private String website;

    @Schema(description = "关键词（单值）")
    private String keyword;

    @Schema(description = "关键词列表")
    private List<String> keywords;

    @Schema(description = "问题来源")
    private String promptSource;

    @Schema(description = "国家代码")
    private String country;

    @Schema(description = "监测平台")
    private List<String> platforms;

    @Schema(description = "状态", example = "active")
    private String status;

    @Schema(description = "备注")
    private String remark;

}
