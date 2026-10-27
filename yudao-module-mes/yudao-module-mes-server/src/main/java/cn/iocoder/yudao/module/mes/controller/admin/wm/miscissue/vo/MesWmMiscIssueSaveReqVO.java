package cn.iocoder.yudao.module.mes.controller.admin.wm.miscissue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES miscellaneous outbound order create / edit request.")
@Data
public class MesWmMiscIssueSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Outbound order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "MI20260302001")
    @NotBlank(message = "Outbound order code is required.")
    private String code;

    @Schema(description = "Outbound order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Inventory adjust outbound.")
    @NotBlank(message = "Outbound order name is required.")
    private String name;

    @Schema(description = "Miscellaneous type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Miscellaneous type is required.")
    private Integer type;

    @Schema(description = "Source document type.", example = "PURCHASE_ORDER")
    private String sourceDocType;
    @Schema(description = "Source document ID.", example = "1")
    private Long sourceDocId;

    @Schema(description = "Source document code.", example = "DOC20260302001")
    private String sourceDocCode;

    @Schema(description = "Outbound Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Outbound Date is required.")
    private LocalDateTime issueDate;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
