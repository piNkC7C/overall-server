package cn.iocoder.yudao.module.mes.controller.admin.wm.miscissue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES miscellaneous outbound order response.")
@Data
public class MesWmMiscIssueRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Outbound order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "MI20260302001")
    private String code;

    @Schema(description = "Outbound order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Inventory adjust outbound.")
    private String name;

    @Schema(description = "Miscellaneous type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Source document type.", example = "PURCHASE_ORDER")
    private String sourceDocType;
    @Schema(description = "Source document ID.", example = "1")
    private Long sourceDocId;

    @Schema(description = "Source document code.", example = "DOC20260302001")
    private String sourceDocCode;

    @Schema(description = "Outbound Date", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime issueDate;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
