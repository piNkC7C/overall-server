package cn.iocoder.yudao.module.mes.controller.admin.wm.returnissue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES production material return order response.")
@Data
public class MesWmReturnIssueRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Material return order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "RI20250226001")
    private String code;

    @Schema(description = "Material return order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Production material return.")
    private String name;

    @Schema(description = "Production work order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long workOrderId;

    @Schema(description = "Production work order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WO20250226001")
    private String workOrderCode;

    @Schema(description = "Workstation ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long workstationId;

    @Schema(description = "Workstation name.", example = "Assembly workstation")
    private String workstationName;

    @Schema(description = "Material return type.", example = "1")
    private Integer type;

    @Schema(description = "Material return Date.")
    private LocalDateTime returnDate;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
