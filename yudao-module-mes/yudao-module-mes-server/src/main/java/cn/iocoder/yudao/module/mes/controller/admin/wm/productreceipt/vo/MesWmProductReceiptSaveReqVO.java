package cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 产品收货单新增/修改 Request VO")
@Data
public class MesWmProductReceiptSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "收货单编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "PR202603010001")
    @NotEmpty(message = "Receiving order code is required.")
    private String code;

    @Schema(description = "收货单名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product receiving order -work order001.")
    @NotEmpty(message = "Receiving order name is required.")
    private String name;

    @Schema(description = "生产工单编号", example = "1")
    private Long workOrderId;

    @Schema(description = "收货日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Receiving Date is required.")
    private LocalDateTime receiptDate;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}
