package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.plan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES stocktake plan response.")
@Data
@ExcelIgnoreUnannotated
public class MesWmStockTakingPlanRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "STP202603080001")
    @ExcelProperty("Plan Code")
    private String code;

    @Schema(description = "Plan name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw-warehouse monthly count")
    @ExcelProperty("Plan Name")
    private String name;

    @Schema(description = "Stocktake type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Count Type")
    private Integer type;

    @Schema(description = "Plan start time.")
    @ExcelProperty("Planned Start Time")
    private LocalDateTime startTime;

    @Schema(description = "Plan end time.")
    @ExcelProperty("Planned End Time")
    private LocalDateTime endTime;

    @Schema(description = "Blind Count", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @ExcelProperty("Blind Count")
    private Boolean blindFlag;

    @Schema(description = "Is not freeze inventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @ExcelProperty("Freeze Inventory")
    private Boolean frozen;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
