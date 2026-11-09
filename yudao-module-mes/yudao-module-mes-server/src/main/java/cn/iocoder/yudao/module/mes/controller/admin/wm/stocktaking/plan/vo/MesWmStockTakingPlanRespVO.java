package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.plan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 盘点方案 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesWmStockTakingPlanRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "方案编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "STP202603080001")
    @ExcelProperty("Plan Code")
    private String code;

    @Schema(description = "方案名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw-warehouse monthly count")
    @ExcelProperty("Plan Name")
    private String name;

    @Schema(description = "盘点类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Count Type")
    private Integer type;

    @Schema(description = "计划开始时间")
    @ExcelProperty("Planned Start Time")
    private LocalDateTime startTime;

    @Schema(description = "计划结束时间")
    @ExcelProperty("Planned End Time")
    private LocalDateTime endTime;

    @Schema(description = "是否盲盘", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @ExcelProperty("Blind Count")
    private Boolean blindFlag;

    @Schema(description = "是否冻结库存", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @ExcelProperty("Freeze Inventory")
    private Boolean frozen;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
