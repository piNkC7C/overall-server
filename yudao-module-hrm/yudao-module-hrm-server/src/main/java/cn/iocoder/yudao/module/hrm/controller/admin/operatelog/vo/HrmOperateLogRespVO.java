package cn.iocoder.yudao.module.hrm.controller.admin.operatelog.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - HRM 操作日志 Response VO")
@Data
public class HrmOperateLogRespVO {

    @Schema(description = "日志编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "操作用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "操作用户名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String userName;

    @Schema(description = "操作用户类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer userType;

    @Schema(description = "日志类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "HRM RecruitingJob Title.")
    private String type;

    @Schema(description = "日志子类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "UpdateRecruitingJob Title.")
    private String subType;

    @Schema(description = "业务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long bizId;

    @Schema(description = "操作内容", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "Updated job posting [Java engineer]")
    private String action;

    @Schema(description = "拓展字段", example = "{}")
    private String extra;

    @Schema(description = "操作时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
