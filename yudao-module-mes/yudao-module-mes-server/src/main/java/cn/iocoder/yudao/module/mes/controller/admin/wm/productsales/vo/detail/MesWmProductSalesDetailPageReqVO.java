package cn.iocoder.yudao.module.mes.controller.admin.wm.productsales.vo.detail;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES sales outbound detail page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmProductSalesDetailPageReqVO extends PageParam {

    @Schema(description = "Outbound orderID.", example = "1")
    private Long salesId;

    @Schema(description = "Outbound order line ID.", example = "1")
    private Long lineId;

}
