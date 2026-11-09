package cn.iocoder.yudao.module.mes.controller.admin.dv.checkplan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 点检保养方案 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesDvCheckPlanRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "方案编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "CHP001")
    @ExcelProperty("Plan Code")
    private String code;

    @Schema(description = "方案名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Injection-molding daily inspection plan")
    @ExcelProperty("Plan Name")
    private String name;

    @Schema(description = "方案类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Plan Type")
    private Integer type;

    @Schema(description = "开始日期")
    @ExcelProperty("Start Date")
    private LocalDateTime startDate;

    @Schema(description = "结束日期")
    @ExcelProperty("End Date")
    private LocalDateTime endDate;

    @Schema(description = "周期类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Cycle Type")
    private Integer cycleType;

    @Schema(description = "周期数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Cycle Count")
    private Integer cycleCount;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
