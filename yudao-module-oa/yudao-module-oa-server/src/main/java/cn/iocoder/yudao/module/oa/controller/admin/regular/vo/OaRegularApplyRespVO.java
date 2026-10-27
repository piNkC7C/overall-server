package cn.iocoder.yudao.module.oa.controller.admin.regular.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - confirmation apply please response.")
@Data
public class OaRegularApplyRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Title.", example = "Probation confirmation request")
    private String title;

    @Schema(description = "Urgency", example = "1")
    private Integer urgency;

    @Schema(description = "Start time.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime startTime;

    @Schema(description = "End time.", type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime endTime;

    @Schema(description = "Days.", example = "1")
    private Integer days;

    @Schema(description = "Probation reflection.", example = "Learned the team workflow and finished assigned tasks")
    private String experience;

    @Schema(description = "Role understanding.", example = "Own project development, delivery, and maintenance")
    private String understanding;

    @Schema(description = "Probation growth.", example = "Can independently deliver features and troubleshoot issues")
    private String growth;

    @Schema(description = "Current gaps.", example = "Cross-team communication still needs improvement")
    private String deficiency;

    @Schema(description = "Work improvement.", example = "Break down tasks and follow progress daily")
    private String improvement;

    @Schema(description = "Product feedback.", example = "Suggest simplifying the expense form")
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
