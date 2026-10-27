package cn.iocoder.yudao.module.mes.controller.admin.qc.template.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES quality inspection plan page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesQcTemplatePageReqVO extends PageParam {

    @Schema(description = "Plan code.", example = "QCT001")
    private String code;

    @Schema(description = "Plan name.", example = "outgoing inspection")
    private String name;

    @Schema(description = "Inspection Type", example = "1")
    private Integer type;

    @Schema(description = "Status.", example = "0")
    private Integer status;

}
