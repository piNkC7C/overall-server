package cn.iocoder.yudao.module.mes.controller.admin.pro.feedback.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 生产报工新增/修改 Request VO")
@Data
public class MesProFeedbackSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "报工单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "FB202503001")
    @NotNull(message = "Work-report number cannot be empty.")
    private String code;

    @Schema(description = "报工类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Work report type is required.")
    private Integer type;

    @Schema(description = "工作站编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Workstation is required.")
    private Long workstationId;

    @Schema(description = "工艺路线编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Routing path is required.")
    private Long routeId;

    @Schema(description = "工序编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Operation is required.")
    private Long processId;

    @Schema(description = "生产工单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Production work order is required.")
    private Long workOrderId;

    @Schema(description = "生产任务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Production task is required.")
    private Long taskId;

    @Schema(description = "产品物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Product material is required.")
    private Long itemId;

    @Schema(description = "过期日期")
    private LocalDateTime expireDate;

    @Schema(description = "生产批号", example = "LOT20260321")
    private String lotNumber;

    @Schema(description = "排产数量", example = "5000.00")
    private BigDecimal scheduledQuantity;

    @Schema(description = "本次报工数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "500.00")
    @NotNull(message = "Work report quantity is required.")
    private BigDecimal feedbackQuantity;

    @Schema(description = "合格品数量", example = "490.00")
    private BigDecimal qualifiedQuantity;

    @Schema(description = "不良品数量", example = "10.00")
    private BigDecimal unqualifiedQuantity;

    @Schema(description = "待检测数量", example = "0")
    private BigDecimal uncheckQuantity;

    @Schema(description = "工废数量", example = "6.00")
    private BigDecimal laborScrapQuantity;

    @Schema(description = "料废数量", example = "4.00")
    private BigDecimal materialScrapQuantity;

    @Schema(description = "其他废品数量", example = "0")
    private BigDecimal otherScrapQuantity;

    @Schema(description = "报工人编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Work report person is required.")
    private Long feedbackUserId;

    @Schema(description = "报工时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Work report time is required.")
    private LocalDateTime feedbackTime;

    @Schema(description = "审核人编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Approval person is required.")
    private Long approveUserId;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

    }
