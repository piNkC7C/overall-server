package cn.iocoder.yudao.module.mes.controller.admin.wm.outsourcereceipt.vo.line;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES subcontract inbound order line page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmOutsourceReceiptLinePageReqVO extends PageParam {

    @Schema(description = "Inbound order code.", example = "1")
    private Long receiptId;

    @Schema(description = "Material code.", example = "1")
    private Long itemId;

}
