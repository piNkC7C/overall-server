package cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES workstation create / edit request.")
@Data
public class MesMdWorkstationSaveReqVO {

    @Schema(description = "Workstation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Workstation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WK001")
    @NotEmpty(message = "Workstation code is required.")
    private String code;

    @Schema(description = "Workstation name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Workstation 1")
    @NotEmpty(message = "Workstation name is required.")
    private String name;

    @Schema(description = "WorkstationLocation.", example = "Zone A line 1")
    private String address;

    @Schema(description = "WorkshopID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Workshop cannot be empty.")
    private Long workshopId;

    @Schema(description = "Operation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Operation is required.")
    private Long processId;

    @Schema(description = "Line-side warehouse ID.", example = "1")
    private Long warehouseId;

    @Schema(description = "Zone code.", example = "1")
    private Long locationId;

    @Schema(description = "Bin code.", example = "1")
    private Long areaId;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    }
