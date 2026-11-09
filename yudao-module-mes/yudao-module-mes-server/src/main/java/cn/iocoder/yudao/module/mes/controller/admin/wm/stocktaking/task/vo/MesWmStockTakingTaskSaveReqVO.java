package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.task.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 盘点任务新增/修改 Request VO")
@Data
public class MesWmStockTakingTaskSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "任务编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "ST202603080001")
    @NotEmpty(message = "Task code is required.")
    private String code;

    @Schema(description = "任务名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw-warehouse monthly count")
    @NotEmpty(message = "Task name is required.")
    private String name;

    @Schema(description = "盘点日期")
    private LocalDateTime takingDate;

    @Schema(description = "盘点类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Stocktake type is required.")
    private Integer type;

    @Schema(description = "盘点人 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Stocktake person is required.")
    private Long userId;

    @Schema(description = "来源方案 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Source plan is required.")
    private Long planId;

    @Schema(description = "开始时间")
    private LocalDateTime startTime;

    @Schema(description = "结束时间")
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
