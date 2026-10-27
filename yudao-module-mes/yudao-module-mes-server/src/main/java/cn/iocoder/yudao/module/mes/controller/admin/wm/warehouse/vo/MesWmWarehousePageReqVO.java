package cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES warehouse page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmWarehousePageReqVO extends PageParam {

    @Schema(description = "Warehouse code.", example = "WH001")
    private String code;

    @Schema(description = "Warehouse name.", example = "Raw Materials.")
    private String name;

    @Schema(description = "Is not freeze.", example = "false")
    private Boolean frozen;

}
