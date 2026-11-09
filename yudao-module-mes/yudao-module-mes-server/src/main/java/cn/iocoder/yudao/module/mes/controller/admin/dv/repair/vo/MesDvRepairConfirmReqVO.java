package cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 维修工单确认完成 Request VO")
@Data
public class MesDvRepairConfirmReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Repair work order code is required.")
    private Long id;

    @Schema(description = "维修完成日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "MaintenancecompleteDate is required.")
    private LocalDateTime finishDate;

}
