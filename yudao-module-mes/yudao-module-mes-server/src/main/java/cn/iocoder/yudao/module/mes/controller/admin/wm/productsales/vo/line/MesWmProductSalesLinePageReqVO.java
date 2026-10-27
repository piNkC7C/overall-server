package cn.iocoder.yudao.module.mes.controller.admin.wm.productsales.vo.line;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "Admin - MES sales shipment line page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmProductSalesLinePageReqVO extends PageParam {

    @Schema(description = "Outbound orderID.", example = "1")
    private Long salesId;

    @Schema(description = "Customer code.", example = "1")
    private Long clientId;

    @Schema(description = "Outbound order IDs. Internal. Filled when filtering by customer.", hidden = true)
    private List<Long> salesIds;

}
