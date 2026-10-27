package cn.iocoder.yudao.module.mes.controller.admin.qc.pendinginspect.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "MES pending inspection task page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesQcPendingInspectPageReqVO extends PageParam {

    @Schema(description = "Source document code.", example = "AN2025001")
    private String sourceDocCode;

    @Schema(description = "Inspection type.", example = "1")
    private Integer qcType;

    @Schema(description = "Material code.", example = "1024")
    private Long itemId;

}
