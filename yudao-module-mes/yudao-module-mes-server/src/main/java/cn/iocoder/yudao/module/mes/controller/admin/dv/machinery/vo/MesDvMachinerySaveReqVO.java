package cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "MES device ledger create / update request VO.")
@Data
public class MesDvMachinerySaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "EQ-001")
    @NotEmpty(message = "Device code is required.")
    private String code;

    @Schema(description = "Device name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "CNC center")
    @NotEmpty(message = "Device name is required.")
    private String name;

    @Schema(description = "Brand.", example = "Siemens")
    private String brand;

    @Schema(description = "Spec / Model", example = "S7-300")
    private String specification;

    @Schema(description = "Device type code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Device type is required.")
    private Long machineryTypeId;

    @Schema(description = "Workshop code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    @NotNull(message = "Workshop is required.")
    private Long workshopId;

    @Schema(description = "Device status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Device status is required.")
    private Integer status;

    @Schema(description = "Last maintenance time.")
    private LocalDateTime lastMaintenTime;

    @Schema(description = "Last inspection time.")
    private LocalDateTime lastCheckTime;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    }
