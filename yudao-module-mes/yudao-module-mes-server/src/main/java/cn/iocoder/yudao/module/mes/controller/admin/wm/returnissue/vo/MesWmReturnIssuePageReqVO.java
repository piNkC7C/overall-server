package cn.iocoder.yudao.module.mes.controller.admin.wm.returnissue.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - MES production material return order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class MesWmReturnIssuePageReqVO extends PageParam {

    @Schema(description = "Material return order code.", example = "RI20250226001")
    private String code;

    @Schema(description = "Material return order name.", example = "Production material return.")
    private String name;

    @Schema(description = "Workstation ID.", example = "1")
    private Long workstationId;

    @Schema(description = "Production work order ID.", example = "1")
    private Long workOrderId;

    @Schema(description = "Material return type.", example = "1")
    private Integer type;

}
