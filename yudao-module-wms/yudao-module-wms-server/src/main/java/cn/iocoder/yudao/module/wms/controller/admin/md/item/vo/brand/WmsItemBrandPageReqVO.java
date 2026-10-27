package cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.brand;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - WMS product brand page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WmsItemBrandPageReqVO extends PageParam {

    @Schema(description = "Brand code.", example = "B00000001")
    private String code;

    @Schema(description = "Brand name.", example = "Huawei")
    private String name;

}
