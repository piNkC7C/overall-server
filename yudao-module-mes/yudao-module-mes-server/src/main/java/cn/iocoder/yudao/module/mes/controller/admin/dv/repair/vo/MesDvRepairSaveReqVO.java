package cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES repair work order create / edit request.")
@Data
public class MesDvRepairSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Repair work order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "REP2024001")
    @NotBlank(message = "Repair work order code is required.")
    private String code;

    @Schema(description = "Repair work order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Injection-molding hydraulic repair")
    @NotBlank(message = "Repair work order name is required.")
    private String name;

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Device is required.")
    private Long machineryId;

    @Schema(description = "Repair date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Repair date cannot be empty.")
    private LocalDateTime requireDate;

    @Schema(description = "MaintenancecompleteDate.")
    private LocalDateTime finishDate;

    @Schema(description = "Accept Date.")
    private LocalDateTime confirmDate;

    @Schema(description = "Maintenance result.", example = "1")
    private Integer result;

    @Schema(description = "Maintenance person user ID.", example = "1")
    private Long acceptedUserId;

    @Schema(description = "Accept person user ID.", example = "1")
    private Long confirmUserId;

    @Schema(description = "Source document type.", example = "1")
    private Integer sourceDocType;

    @Schema(description = "Source document code.", example = "1")
    private Long sourceDocId;

    @Schema(description = "Source document code.", example = "DOC001")
    private String sourceDocCode;

    @Schema(description = "Notes.", example = "Sample notes.")
    private String remark;

}
