package cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES workstation page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesMdWorkstationPageReqVO extends PageParam {

    @Schema(description = "Workstation code.", example = "WK001")
    private String code;

    @Schema(description = "Workstation name.", example = "Workstation 1")
    private String name;

    @Schema(description = "WorkshopID.", example = "1")
    private Long workshopId;

    @Schema(description = "Operation code.", example = "1")
    private Long processId;

    @Schema(description = "Status.", example = "0")
    private Integer status;

}
