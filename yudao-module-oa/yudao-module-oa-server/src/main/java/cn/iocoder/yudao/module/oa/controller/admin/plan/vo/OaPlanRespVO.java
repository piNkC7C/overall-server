package cn.iocoder.yudao.module.oa.controller.admin.plan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - OA 工作计划 Response VO")
@Data
public class OaPlanRespVO {

    @Schema(description = "计划编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "用户昵称", example = "Overall.")
    private String userName;

    @Schema(description = "部门编号", example = "1")
    private Long deptId;

    @Schema(description = "部门名称", example = "Engineering.")
    private String deptName;

    @Schema(description = "计划类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "计划状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "This week's plan")
    private String title;

    @Schema(description = "标签", example = "This week's focus")
    private String label;

    @Schema(description = "计划内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "Finish office-supply count variances next week and restock as needed.")
    private String content;

    @Schema(description = "计划总结", example = "Completed this week plan Alltask.")
    private String summary;

    @Schema(description = "计划点评", example = "The plan is on track. Continue follow-up.")
    private String comment;

    @Schema(description = "开始时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime startTime;

    @Schema(description = "结束时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime endTime;

    @Schema(description = "附件地址列表", example = "[\"https://example.com/file.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

}
