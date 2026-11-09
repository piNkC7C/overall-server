package cn.iocoder.yudao.module.mes.controller.admin.wm.outsourcereceipt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 外协入库单新增/修改 Request VO")
@Data
public class MesWmOutsourceReceiptSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "入库单编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "OR2026030001")
    @NotEmpty(message = "Inbound order code is required.")
    private String code;

    @Schema(description = "入库单名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Subcontract inbound")
    @NotEmpty(message = "Inbound order name is required.")
    private String name;

    @Schema(description = "外协工单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Subcontract work order is required.")
    private Long workOrderId;

    @Schema(description = "供应商编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Supplier is required.")
    private Long vendorId;

    @Schema(description = "入库日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Inbound date is required.")
    private LocalDateTime receiptDate;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}
