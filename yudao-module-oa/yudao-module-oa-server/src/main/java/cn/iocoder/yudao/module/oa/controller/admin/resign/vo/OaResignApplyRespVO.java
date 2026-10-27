package cn.iocoder.yudao.module.oa.controller.admin.resign.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - offboarding apply please response.")
@Data
public class OaResignApplyRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Title.", example = "Offboarding apply please.")
    private String title;

    @Schema(description = "Urgency", example = "1")
    private Integer urgency;

    @Schema(description = "Apply please reason.", example = "Resigning for career development")
    private String reason;

    @Schema(description = "Handover personuser ID.", example = "1024")
    private Long handoverUserId;

    @Schema(description = "Open items.", example = "Customer files and project docs to hand over")
    private String unfinishedWork;

    @Schema(description = "Has unfinished expenses.", example = "false")
    private Boolean hasPendingReimbursement;

    @Schema(description = "Applicant comments.", example = "Suggest improving new-hire training materials")
    private String suggestion;

    @Schema(description = "Approval status.", example = "-1")
    private Integer status;

    @Schema(description = "Workflow instance code.", example = "1024")
    private String processInstanceId;

    @Schema(description = "Apply please person code.", example = "1024")
    private String creator;

    @Schema(description = "Apply please person Nickname.", example = "John.")
    private String creatorName;

    @Schema(description = "Apply please time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;
}
