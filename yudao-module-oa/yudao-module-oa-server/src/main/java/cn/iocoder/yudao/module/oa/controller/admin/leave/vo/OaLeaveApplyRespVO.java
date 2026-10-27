package cn.iocoder.yudao.module.oa.controller.admin.leave.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - leave request response.")
@Data
public class OaLeaveApplyRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Title.", example = "Personal leave request")
    private String title;

    @Schema(description = "Urgency", example = "1")
    private Integer urgency;

    @Schema(description = "Leave Type", example = "1")
    private Integer type;

    @Schema(description = "Start time.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime startTime;

    @Schema(description = "End time.", type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime endTime;

    @Schema(description = "Days.", example = "1")
    private Integer days;

    @Schema(description = "Apply please reason.", example = "Handle personal matters")
    private String reason;

    @Schema(description = "Approval status.", example = "-1")
    private Integer status;

    @Schema(description = "Workflow instance code.", example = "1024")
    private String processInstanceId;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "Apply please person code.", example = "1024")
    private String creator;

    @Schema(description = "Apply please person Nickname.", example = "John.")
    private String creatorName;

    @Schema(description = "Apply please time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;
}
