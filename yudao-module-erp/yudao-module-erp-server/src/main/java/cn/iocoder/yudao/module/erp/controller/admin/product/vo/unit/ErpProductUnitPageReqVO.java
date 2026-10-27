package cn.iocoder.yudao.module.erp.controller.admin.product.vo.unit;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - ERP product order characters page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpProductUnitPageReqVO extends PageParam {

    @Schema(description = "Order characters name.", example = "Overall.")
    private String name;

    @Schema(description = "Order characters status.", example = "1")
    private Integer status;

}