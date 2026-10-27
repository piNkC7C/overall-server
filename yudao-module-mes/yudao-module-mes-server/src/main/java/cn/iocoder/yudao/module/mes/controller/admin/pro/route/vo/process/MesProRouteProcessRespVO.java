package cn.iocoder.yudao.module.mes.controller.admin.pro.route.vo.process;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES routing pathoperation response.")
@Data
public class MesProRouteProcessRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Routing path code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long routeId;

    @Schema(description = "Operation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long processId;

    @Schema(description = "Operation code.")
    private String processCode;

    @Schema(description = "Operation name.")
    private String processName;

    @Schema(description = "No.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sort;

    @Schema(description = "Next operation ID.")
    private Long nextProcessId;

    @Schema(description = "Next operation name.")
    private String nextProcessName;

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

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
