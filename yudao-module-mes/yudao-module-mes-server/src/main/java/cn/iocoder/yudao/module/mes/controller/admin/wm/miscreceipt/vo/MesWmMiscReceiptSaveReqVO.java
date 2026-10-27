package cn.iocoder.yudao.module.mes.controller.admin.wm.miscreceipt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES miscellaneous inbound order create / edit request.")
@Data
public class MesWmMiscReceiptSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Inbound order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "MR2026030001")
    @NotEmpty(message = "Inbound order code is required.")
    private String code;

    @Schema(description = "Inbound order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Material return inbound order.")
    @NotEmpty(message = "Inbound order name is required.")
    private String name;

    @Schema(description = "Miscellaneous type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Miscellaneous type is required.")
    private Integer type;

    @Schema(description = "Source document type.", example = "WORK_ORDER")
    private String sourceDocType;
    @Schema(description = "Source document ID.", example = "1")
    private Long sourceDocId;

    @Schema(description = "Source document code.", example = "WO2026030001")
    private String sourceDocCode;

    @Schema(description = "Inbound date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Inbound date is required.")
    private LocalDateTime receiptDate;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
