package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.plan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 盘点方案新增/修改 Request VO")
@Data
public class MesWmStockTakingPlanSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "方案编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "STP202603080001")
    @NotEmpty(message = "Plan code is required.")
    private String code;

    @Schema(description = "方案名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw-warehouse monthly count")
    @NotEmpty(message = "Plan name is required.")
    private String name;

    @Schema(description = "盘点类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Stocktake type is required.")
    private Integer type;

    @Schema(description = "计划开始时间")
    private LocalDateTime startTime;

    @Schema(description = "计划结束时间")
    private LocalDateTime endTime;

    @Schema(description = "是否盲盘", example = "false")
    @NotNull(message = "Blind Count is required.")
    private Boolean blindFlag;

    @Schema(description = "是否冻结库存", example = "false")
    @NotNull(message = "Is not freeze inventory is required.")
    private Boolean frozen;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}
