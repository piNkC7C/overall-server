package cn.iocoder.yudao.module.mes.controller.admin.pro.route.vo.process;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES routing pathoperation create / edit request.")
@Data
public class MesProRouteProcessSaveReqVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Routing path code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Routing path code is required.")
    private Long routeId;

    @Schema(description = "Operation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Operation code is required.")
    private Long processId;

    @Schema(description = "No.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "No. is required.")
    private Integer sort;

    @Schema(description = "Relation to the next operation.", example = "0")
    private Integer linkType;

    @Schema(description = "Setup time (minutes).", example = "10")
    private Integer prepareTime;

    @Schema(description = "Waiting for time (Minutes).", example = "5")
    private Integer waitTime;

    @Schema(description = "Gantt color.", example = "#00AEF3")
    private String colorCode;

    @Schema(description = "Key operation.", example = "false")
    private Boolean keyFlag;

    @Schema(description = "Is not quality inspection operation.", example = "false")
    private Boolean checkFlag;

    @Schema(description = "Notes.")
    private String remark;

}
