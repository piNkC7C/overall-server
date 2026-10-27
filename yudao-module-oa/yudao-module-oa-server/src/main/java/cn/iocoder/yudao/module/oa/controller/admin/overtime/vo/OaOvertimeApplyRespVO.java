package cn.iocoder.yudao.module.oa.controller.admin.overtime.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Overtime request response VO.")
@Data
public class OaOvertimeApplyRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Title.", example = "Go-live overtime request")
    private String title;

    @Schema(description = "Urgency", example = "1")
    private Integer urgency;

    @Schema(description = "Overtime type.", example = "1")
    private Integer type;

    @Schema(description = "Start time.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime startTime;

    @Schema(description = "End time.", type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime endTime;

    @Schema(description = "Days.", example = "1")
    private BigDecimal days;

    @Schema(description = "Apply please reason.", example = "Finish pre-launch integration")
    private String reason;

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
