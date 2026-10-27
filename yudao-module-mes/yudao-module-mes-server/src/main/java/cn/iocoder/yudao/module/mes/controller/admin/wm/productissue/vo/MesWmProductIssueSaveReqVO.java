package cn.iocoder.yudao.module.mes.controller.admin.wm.productissue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES material issue outbound order create / edit request.")
@Data
public class MesWmProductIssueSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Material issue order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ISSUE20250226001")
    @NotBlank(message = "Material issue order code is required.")
    private String code;

    @Schema(description = "Material issue order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Production material issue.")
    @NotBlank(message = "Material issue order name is required.")
    private String name;

    @Schema(description = "Production work order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Production work order ID is required.")
    private Long workOrderId;

    @Schema(description = "Workstation ID.", example = "1")
    private Long workstationId;

    @Schema(description = "Requirement time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Requirement time is required.")
    private LocalDateTime requiredTime;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    }
