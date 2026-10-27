package cn.iocoder.yudao.module.mes.controller.admin.qc.defectrecord.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.mes.enums.qc.MesQcTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES quality inspection defect record page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesQcDefectRecordPageReqVO extends PageParam {

    @Schema(description = "Inspection type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inspection type is required.")
    @InEnum(MesQcTypeEnum.class)
    private Integer qcType;

    @Schema(description = "Inspection ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Inspection ID is required.")
    private Long qcId;

    @Schema(description = "Inspection line ID.", example = "200")
    private Long lineId;

}
