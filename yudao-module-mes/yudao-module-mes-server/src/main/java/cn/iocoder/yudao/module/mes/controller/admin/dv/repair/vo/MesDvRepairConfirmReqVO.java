package cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES repair work order confirm complete request.")
@Data
public class MesDvRepairConfirmReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Repair work order code is required.")
    private Long id;

    @Schema(description = "MaintenancecompleteDate.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "MaintenancecompleteDate is required.")
    private LocalDateTime finishDate;

}
