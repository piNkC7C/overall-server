package cn.iocoder.yudao.module.wms.controller.admin.md.warehouse.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - WMS warehouse page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WmsWarehousePageReqVO extends PageParam {

    @Schema(description = "Warehouse code.", example = "WH001")
    private String code;

    @Schema(description = "Warehouse name.", example = "Raw Materials.")
    private String name;

}
