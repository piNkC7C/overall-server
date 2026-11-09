package cn.iocoder.yudao.module.mes.controller.admin.wm.productissue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 领料出库单新增/修改 Request VO")
@Data
public class MesWmProductIssueSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "领料单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "ISSUE20250226001")
    @NotBlank(message = "Material issue order code is required.")
    private String code;

    @Schema(description = "领料单名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Production material issue.")
    @NotBlank(message = "Material issue order name is required.")
    private String name;

    @Schema(description = "生产工单 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Production work order ID is required.")
    private Long workOrderId;

    @Schema(description = "工作站 ID", example = "1")
    private Long workstationId;

    @Schema(description = "需求时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Requirement time is required.")
    private LocalDateTime requiredTime;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

    }
