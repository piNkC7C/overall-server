package cn.iocoder.yudao.module.mes.controller.admin.wm.returnissue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 生产退料单新增/修改 Request VO")
@Data
public class MesWmReturnIssueSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "退料单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "RI20250226001")
    @NotBlank(message = "Material return order code is required.")
    private String code;

    @Schema(description = "退料单名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Production material return.")
    @NotBlank(message = "Material return order name is required.")
    private String name;

    @Schema(description = "生产工单 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Production work order ID is required.")
    private Long workOrderId;

    @Schema(description = "工作站 ID", example = "1")
    private Long workstationId;

    @Schema(description = "退料类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material return type is required.")
    private Integer type;

    @Schema(description = "退料日期")
    private LocalDateTime returnDate;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}
