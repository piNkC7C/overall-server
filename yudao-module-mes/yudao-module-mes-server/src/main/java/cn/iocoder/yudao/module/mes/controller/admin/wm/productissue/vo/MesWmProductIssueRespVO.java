package cn.iocoder.yudao.module.mes.controller.admin.wm.productissue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES material issue outbound order response.")
@Data
public class MesWmProductIssueRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Material issue order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ISSUE20250226001")
    private String code;

    @Schema(description = "Material issue order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Production material issue.")
    private String name;

    @Schema(description = "Production work order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long workOrderId;

    @Schema(description = "Production work order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WO20250226001")
    private String workOrderCode;

    @Schema(description = "Workstation ID.", example = "1")
    private Long workstationId;

    @Schema(description = "Workstation name.", example = "Assembly workstation")
    private String workstationName;

    @Schema(description = "Customer code.", example = "C001")
    private String clientCode;

    @Schema(description = "Customer name.", example = "A a customer.")
    private String clientName;

    @Schema(description = "Production task ID.", example = "1")
    private Long taskId;

    @Schema(description = "Material issue Date.")
    private LocalDateTime issueDate;

    @Schema(description = "Requirement time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime requiredTime;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
