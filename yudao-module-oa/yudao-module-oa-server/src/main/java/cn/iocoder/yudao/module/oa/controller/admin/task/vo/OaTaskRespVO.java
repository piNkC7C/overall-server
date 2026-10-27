package cn.iocoder.yudao.module.oa.controller.admin.task.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - OA task response.")
@Data
public class OaTaskRespVO {

    @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Publisher user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long publisherUserId;

    @Schema(description = "PublisherNickname.", example = "Overall.")
    private String publisherUserName;

    @Schema(description = "Publisherdepartment name.", example = "Engineering.")
    private String publisherDeptName;

    @Schema(description = "Task type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Overall Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer status;

    @Schema(description = "Current Recipient status.", example = "3")
    private Integer receiverStatus;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "This week's office-supply count")
    private String title;

    @Schema(description = "TaskDescription.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Finish this week's office-supply count and submit results")
    private String description;

    @Schema(description = "Task review.", example = "Completed on time. Count result is accurate.")
    private String comment;

    @Schema(description = "Start time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime startTime;

    @Schema(description = "End time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime endTime;

    @Schema(description = "Is not Pin.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean top;

    @Schema(description = "Is not cancel.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean canceled;

    @Schema(description = "Recipient list.")
    private List<OaTaskReceiverRespVO> receivers;

    @Schema(description = "Feedback log list.")
    private List<OaTaskLogRespVO> logs;

    @Schema(description = "Published", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime publishTime;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

    @Schema(description = "Edit time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime updateTime;

}
