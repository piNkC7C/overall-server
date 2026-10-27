package cn.iocoder.yudao.module.mes.controller.admin.md.unitmeasure.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES unit of measure page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesMdUnitMeasurePageReqVO extends PageParam {

    @Schema(description = "Order characters code.", example = "KG")
    private String code;

    @Schema(description = "Order characters name.", example = "kg")
    private String name;

    @Schema(description = "Status.", example = "0")
    private Integer status;

}
