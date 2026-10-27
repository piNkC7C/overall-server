package cn.iocoder.yudao.module.mes.controller.admin.wm.itemreceipt.vo.line;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "Admin - MES purchase receipt line page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmItemReceiptLinePageReqVO extends PageParam {

    @Schema(description = "Inbound order code.", example = "1")
    private Long receiptId;

    @Schema(description = "Supplier code.", example = "1")
    private Long vendorId;

    @Schema(description = "Inbound order IDs. Internal. Filled when filtering by supplier.", hidden = true)
    private List<Long> receiptIds;

}
