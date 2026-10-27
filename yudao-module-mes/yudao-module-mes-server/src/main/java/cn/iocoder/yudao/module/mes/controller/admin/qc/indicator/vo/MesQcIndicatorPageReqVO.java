package cn.iocoder.yudao.module.mes.controller.admin.qc.indicator.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES quality inspection metric page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesQcIndicatorPageReqVO extends PageParam {

    @Schema(description = "Inspect item code.", example = "QI001")
    private String code;

    @Schema(description = "Inspect item name.", example = "Length.")
    private String name;

    @Schema(description = "Inspect item type.", example = "1")
    private Integer type;

    @Schema(description = "Result value type.", example = "1")
    private Integer resultType;

}
