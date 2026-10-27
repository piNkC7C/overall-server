package cn.iocoder.yudao.module.hrm.controller.admin.operatelog.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - HRM Activity Log response.")
@Data
public class HrmOperateLogRespVO {

    @Schema(description = "Log ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Action user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "Operator name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String userName;

    @Schema(description = "Action user type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer userType;

    @Schema(description = "Log type", requiredMode = Schema.RequiredMode.REQUIRED, example = "HRM RecruitingJob Title.")
    private String type;

    @Schema(description = "Log subtype.", requiredMode = Schema.RequiredMode.REQUIRED, example = "UpdateRecruitingJob Title.")
    private String subType;

    @Schema(description = "Business code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long bizId;

    @Schema(description = "Action content.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "Updated job posting [Java engineer]")
    private String action;

    @Schema(description = "Extra JSON", example = "{}")
    private String extra;

    @Schema(description = "Action time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
