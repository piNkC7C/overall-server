package cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES product receiving order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmProductReceiptPageReqVO extends PageParam {

    @Schema(description = "Receiving order code.", example = "PR202603010001")
    private String code;

    @Schema(description = "Receiving order name.", example = "Product receiving order -work order001.")
    private String name;

    @Schema(description = "Production work order code.", example = "1")
    private Long workOrderId;

    @Schema(description = "Product material code.", example = "1")
    private Long itemId;

}
