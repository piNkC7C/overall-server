package cn.iocoder.yudao.module.oa.controller.admin.schedule.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - OA Calendar response.")
@Data
public class OaScheduleRespVO {

    @Schema(description = "Calendar code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Creator user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private String creator;

    @Schema(description = "Creator nickname.", example = "Overall.")
    private String creatorName;

    @Schema(description = "Publisherdepartment name.", example = "R&D")
    private String creatorDeptName;

    @Schema(description = "Calendar type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Priority", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer priority;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Project review meeting")
    private String title;

    @Schema(description = "Description", example = "Finish count-variance review next week")
    private String description;

    @Schema(description = "Start time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime startTime;

    @Schema(description = "End time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime endTime;

    @Schema(description = "Remind.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean remind;

    @Schema(description = "Participant user IDs.", example = "[1, 2]")
    private List<Long> participantUserIds;

    @Schema(description = "Participantnicknamelist.", example = "[\"John\", \"Jane\"]")
    private List<String> participantUserNames;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

    @Schema(description = "Participant read info. Detail only.")
    private List<Participant> participants;

    @Schema(description = "Admin - Calendarparticipant response.")
    @Data
    public static class Participant {

        @Schema(description = "Participantuser ID.", example = "1")
        private Long userId;

        @Schema(description = "Participantnickname.", example = "Overall.")
        private String userName;

        @Schema(description = "Is not Read.", example = "false")
        private Boolean readStatus;

        @Schema(description = "First read time.", type = "integer", format = "int64", example = "1789347600000")
        private LocalDateTime readTime;

    }

}
