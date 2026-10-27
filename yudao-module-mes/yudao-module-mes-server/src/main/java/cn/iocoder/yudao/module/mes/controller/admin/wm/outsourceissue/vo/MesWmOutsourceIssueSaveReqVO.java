package cn.iocoder.yudao.module.mes.controller.admin.wm.outsourceissue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES subcontract issue order create / edit request.")
@Data
public class MesWmOutsourceIssueSaveReqVO {

    @Schema(description = "Issue materials order ID.", example = "1024")
    private Long id;

    @Schema(description = "Issue materials order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WOS202603020001")
    @NotEmpty(message = "Issue materials order code is required.")
    private String code;

    @Schema(description = "Issue materials order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Subcontract issue order 001.")
    @NotEmpty(message = "Issue materials order name is required.")
    private String name;

    @Schema(description = "SupplierID.", example = "1")
    private Long vendorId;

    @Schema(description = "Production work orderID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Production work orderID is required.")
    private Long workOrderId;

    @Schema(description = "Issue materials Date.")
    private LocalDateTime issueDate;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
