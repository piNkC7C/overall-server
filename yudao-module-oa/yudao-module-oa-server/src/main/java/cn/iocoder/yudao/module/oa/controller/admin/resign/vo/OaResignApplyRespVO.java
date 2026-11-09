package cn.iocoder.yudao.module.oa.controller.admin.resign.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 离职申请 Response VO")
@Data
public class OaResignApplyRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "标题", example = "Offboarding apply please.")
    private String title;

    @Schema(description = "紧急程度", example = "1")
    private Integer urgency;

    @Schema(description = "申请原因", example = "Resigning for career development")
    private String reason;

    @Schema(description = "工作交接人用户编号", example = "1024")
    private Long handoverUserId;

    @Schema(description = "未完成事宜", example = "Customer files and project docs to hand over")
    private String unfinishedWork;

    @Schema(description = "是否有费用报销未完成", example = "false")
    private Boolean hasPendingReimbursement;

    @Schema(description = "申请人意见建议", example = "Suggest improving new-hire training materials")
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
