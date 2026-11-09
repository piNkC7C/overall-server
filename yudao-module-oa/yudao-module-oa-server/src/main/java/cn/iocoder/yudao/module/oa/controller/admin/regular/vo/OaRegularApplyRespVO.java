package cn.iocoder.yudao.module.oa.controller.admin.regular.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 转正申请 Response VO")
@Data
public class OaRegularApplyRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "标题", example = "Probation confirmation request")
    private String title;

    @Schema(description = "紧急程度", example = "1")
    private Integer urgency;

    @Schema(description = "开始时间", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime startTime;

    @Schema(description = "结束时间", type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime endTime;

    @Schema(description = "天数", example = "1")
    private Integer days;

    @Schema(description = "试用期心得", example = "Learned the team workflow and finished assigned tasks")
    private String experience;

    @Schema(description = "岗位职责理解", example = "Own project development, delivery, and maintenance")
    private String understanding;

    @Schema(description = "试用期成长", example = "Can independently deliver features and troubleshoot issues")
    private String growth;

    @Schema(description = "目前不足", example = "Cross-team communication still needs improvement")
    private String deficiency;

    @Schema(description = "工作改进", example = "Break down tasks and follow progress daily")
    private String improvement;

    @Schema(description = "产品意见建议", example = "Suggest simplifying the expense form")
    private String suggestion;

    @Schema(description = "审批状态", example = "-1")
    private Integer status;

    @Schema(description = "流程实例编号", example = "1024")
    private String processInstanceId;

    @Schema(description = "申请人编号", example = "1024")
    private String creator;

    @Schema(description = "申请人昵称", example = "John.")
    private String creatorName;

    @Schema(description = "申请时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;
}
