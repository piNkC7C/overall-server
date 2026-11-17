package cn.iocoder.yudao.module.oa.controller.admin.schedule.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - OA 日程 Response VO")
@Data
public class OaScheduleRespVO {

    @Schema(description = "日程编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "创建人用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private String creator;

    @Schema(description = "创建人用户昵称", example = "Overall.")
    private String creatorName;

    @Schema(description = "发布人部门名称", example = "R&D")
    private String creatorDeptName;

    @Schema(description = "日程类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "优先级", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer priority;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Project review meeting")
    private String title;

    @Schema(description = "描述", example = "Finish count-variance review next week")
    private String description;

    @Schema(description = "开始时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime startTime;

    @Schema(description = "结束时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime endTime;

    @Schema(description = "是否提醒", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean remind;

    @Schema(description = "提醒提前分钟数，0=准时", example = "15")
    private Integer remindMinutes;

    @Schema(description = "日程状态：0未执行 1执行中 2已结束 3已取消", example = "0")
    private Integer status;

    @Schema(description = "状态变更时间", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime processTime;

    @Schema(description = "参与人用户编号列表", example = "[1, 2]")
    private List<Long> participantUserIds;

    @Schema(description = "参与人用户昵称列表", example = "[\"John\", \"Jane\"]")
    private List<String> participantUserNames;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

    @Schema(description = "参与人阅读信息，仅详情返回")
    private List<Participant> participants;

    @Schema(description = "管理后台 - 日程参与人 Response VO")
    @Data
    public static class Participant {

        @Schema(description = "参与人用户编号", example = "1")
        private Long userId;

        @Schema(description = "参与人用户昵称", example = "Overall.")
        private String userName;

        @Schema(description = "是否已读", example = "false")
        private Boolean readStatus;

        @Schema(description = "首次阅读时间", type = "integer", format = "int64", example = "1789347600000")
        private LocalDateTime readTime;

    }

}
