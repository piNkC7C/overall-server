package cn.iocoder.yudao.module.mes.controller.admin.tm.tool.vo.type;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES tool type page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesTmToolTypePageReqVO extends PageParam {

    @Schema(description = "Type code.", example = "TT-001")
    private String code;

    @Schema(description = "Type name.", example = "Milling cutter")
    private String name;

    @Schema(description = "Maintenance Type", example = "1")
    private Integer maintenType;

}
