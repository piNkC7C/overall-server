package cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt.vo.line;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES product receiving order line page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmProductReceiptLinePageReqVO extends PageParam {

    @Schema(description = "Receiving order code.", example = "1")
    private Long receiptId;

}
