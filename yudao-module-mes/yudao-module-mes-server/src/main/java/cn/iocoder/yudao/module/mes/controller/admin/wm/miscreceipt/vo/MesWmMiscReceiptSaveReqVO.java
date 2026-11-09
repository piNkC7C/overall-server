package cn.iocoder.yudao.module.mes.controller.admin.wm.miscreceipt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 杂项入库单新增/修改 Request VO")
@Data
public class MesWmMiscReceiptSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "入库单编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "MR2026030001")
    @NotEmpty(message = "Inbound order code is required.")
    private String code;

    @Schema(description = "入库单名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Material return inbound order.")
    @NotEmpty(message = "Inbound order name is required.")
    private String name;

    @Schema(description = "杂项类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Miscellaneous type is required.")
    private Integer type;

    @Schema(description = "来源单据类型", example = "WORK_ORDER")
    private String sourceDocType;
    @Schema(description = "来源单据 ID", example = "1")
    private Long sourceDocId;

    @Schema(description = "来源单据编码", example = "WO2026030001")
    private String sourceDocCode;

    @Schema(description = "入库日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Inbound date is required.")
    private LocalDateTime receiptDate;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}
