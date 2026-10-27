package cn.iocoder.yudao.module.mes.controller.admin.wm.returnissue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES production material return order create / edit request.")
@Data
public class MesWmReturnIssueSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Material return order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "RI20250226001")
    @NotBlank(message = "Material return order code is required.")
    private String code;

    @Schema(description = "Material return order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Production material return.")
    @NotBlank(message = "Material return order name is required.")
    private String name;

    @Schema(description = "Production work order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Production work order ID is required.")
    private Long workOrderId;

    @Schema(description = "Workstation ID.", example = "1")
    private Long workstationId;

    @Schema(description = "Material return type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material return type is required.")
    private Integer type;

    @Schema(description = "Material return Date.")
    private LocalDateTime returnDate;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
