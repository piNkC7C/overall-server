package cn.iocoder.yudao.module.crm.controller.admin.operatelog.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;

import java.time.LocalDateTime;

@Schema(description = "Admin - CRM Activity Log response.")
@Data
@ExcelIgnoreUnannotated
public class CrmOperateLogRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    private Long id;

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String userName;

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer userType;

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    private String type;

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Edit customer.")
    private String subType;

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    private Long bizId;

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Changed something from A to B")
    private String action;

    @Schema(description = "Code.", example = "{orderId: 1}")
    private String extra;

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-01-01")
    private LocalDateTime createTime;

}
