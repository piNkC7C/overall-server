package cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo.area;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES bin page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmWarehouseAreaPageReqVO extends PageParam {

    @Schema(description = "Bin code.", example = "A001")
    private String code;

    @Schema(description = "Bin name.", example = "Default bin.")
    private String name;

    @Schema(description = "Zone code.", example = "1")
    private Long locationId;

    @Schema(description = "Location X.", example = "1")
    private Integer positionX;

    @Schema(description = "Location Y.", example = "1")
    private Integer positionY;

    @Schema(description = "Location Z.", example = "1")
    private Integer positionZ;

}
