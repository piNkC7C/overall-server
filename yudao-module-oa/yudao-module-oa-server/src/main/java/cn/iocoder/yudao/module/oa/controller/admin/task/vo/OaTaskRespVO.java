package cn.iocoder.yudao.module.oa.controller.admin.task.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - OA 任务 Response VO")
@Data
public class OaTaskRespVO {

    @Schema(description = "任务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "发布人用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long publisherUserId;

    @Schema(description = "发布人昵称", example = "Overall.")
    private String publisherUserName;

    @Schema(description = "发布人部门名称", example = "Engineering.")
    private String publisherDeptName;

    @Schema(description = "任务类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "总体状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer status;

    @Schema(description = "当前接收人的状态", example = "3")
    private Integer receiverStatus;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "This week's office-supply count")
    private String title;

    @Schema(description = "任务描述", requiredMode = Schema.RequiredMode.REQUIRED, example = "Finish this week's office-supply count and submit results")
    private String description;

    @Schema(description = "任务评价", example = "Completed on time. Count result is accurate.")
    private String comment;

    @Schema(description = "开始时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime startTime;

    @Schema(description = "结束时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime endTime;

    @Schema(description = "是否置顶", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean top;

    @Schema(description = "是否取消", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean canceled;

    @Schema(description = "接收人列表")
    private List<OaTaskReceiverRespVO> receivers;

    @Schema(description = "反馈日志列表")
    private List<OaTaskLogRespVO> logs;

    @Schema(description = "发布时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime publishTime;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

    @Schema(description = "修改时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime updateTime;

}
