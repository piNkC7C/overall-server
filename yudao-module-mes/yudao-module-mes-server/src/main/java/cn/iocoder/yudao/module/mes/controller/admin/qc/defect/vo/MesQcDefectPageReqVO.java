package cn.iocoder.yudao.module.mes.controller.admin.qc.defect.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES defect type page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesQcDefectPageReqVO extends PageParam {

    @Schema(description = "Defect code.", example = "DF001")
    private String code;

    @Schema(description = "Defect Description.", example = "Appearance defect")
    private String name;

    @Schema(description = "Inspect item type.", example = "2")
    private Integer type;

    @Schema(description = "Defect level.", example = "1")
    private Integer level;

}
