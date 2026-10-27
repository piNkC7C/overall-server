package cn.iocoder.yudao.module.bpm.controller.admin.oa.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - leave request response.")
@Data
public class BpmOALeaveRespVO {

    @Schema(description = "Leave form ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Leave Type, see bpm_oa_type enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Reason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Read the docs")
    private String reason;

    @Schema(description = "Apply please time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Leave start time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime startTime;

    @Schema(description = "Leave end time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime endTime;

    @Schema(description = "Workflow code.")
    private String processInstanceId;

    @Schema(description = "Approval result.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status; // See BpmProcessInstanceStatusEnum enum

}
