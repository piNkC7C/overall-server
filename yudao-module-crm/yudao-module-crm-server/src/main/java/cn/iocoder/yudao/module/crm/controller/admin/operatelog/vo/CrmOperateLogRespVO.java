package cn.iocoder.yudao.module.crm.controller.admin.operatelog.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - CRM 操作日志 Response VO")
@Data
@ExcelIgnoreUnannotated
public class CrmOperateLogRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    private Long id;

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String userName;

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer userType;

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    private String type;

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "Edit customer.")
    private String subType;

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    private Long bizId;

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "Changed something from A to B")
    private String action;

    @Schema(description = "编号", example = "{orderId: 1}")
    private String extra;

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-01-01")
    private LocalDateTime createTime;

}
