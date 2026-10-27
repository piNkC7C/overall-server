package cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo.location;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES zone page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmWarehouseLocationPageReqVO extends PageParam {

    @Schema(description = "Zone code.", example = "L001")
    private String code;

    @Schema(description = "Zone name.", example = "Raw-material zone")
    private String name;

    @Schema(description = "Warehouse code.", example = "1")
    private Long warehouseId;

}
