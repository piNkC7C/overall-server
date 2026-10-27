package cn.iocoder.yudao.module.mes.controller.admin.pro.card.vo.process;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES routing card operationrecord response.")
@Data
public class MesProCardProcessRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Routing card code.", example = "100")
    private Long cardId;

    @Schema(description = "No.", example = "1")
    private Integer sort;

    @Schema(description = "Operation code.", example = "200")
    private Long processId;

    @Schema(description = "Operation code.", example = "PROC-001")
    private String processCode;

    @Schema(description = "Operation name.", example = "Welding")
    private String processName;

    @Schema(description = "Operation start time.")
    private LocalDateTime inputTime;

    @Schema(description = "Operation end time.")
    private LocalDateTime outputTime;

    @Schema(description = "Input quantity.", example = "100.00")
    private BigDecimal inputQuantity;

    @Schema(description = "Output Qty", example = "98.00")
    private BigDecimal outputQuantity;

    @Schema(description = "Failed quantity quantity.", example = "2.00")
    private BigDecimal unqualifiedQuantity;

    @Schema(description = "WorkstationID.", example = "300")
    private Long workstationId;

    @Schema(description = "Workstationcode.", example = "WS-001")
    private String workstationCode;

    @Schema(description = "Workstationname.", example = "Welding station 1")
    private String workstationName;

    @Schema(description = "Action person code.", example = "400")
    private Long userId;

    @Schema(description = "Action person name.", example = "John.")
    private String nickname;

    @Schema(description = "In-process inspection number.", example = "500")
    private Long ipqcId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
