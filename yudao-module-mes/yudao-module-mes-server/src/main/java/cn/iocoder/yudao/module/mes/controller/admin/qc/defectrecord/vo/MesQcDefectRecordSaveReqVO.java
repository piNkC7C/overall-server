package cn.iocoder.yudao.module.mes.controller.admin.qc.defectrecord.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.mes.enums.qc.MesQcDefectLevelEnum;
import cn.iocoder.yudao.module.mes.enums.qc.MesQcTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - MES 质检缺陷记录新增/修改 Request VO")
@Data
public class MesQcDefectRecordSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "检验类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inspection type is required.")
    @InEnum(MesQcTypeEnum.class)
    private Integer qcType;

    @Schema(description = "检验单 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Inspection ID is required.")
    private Long qcId;

    @Schema(description = "检验行 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    @NotNull(message = "Inspection line ID is required.")
    private Long lineId;

    @Schema(description = "缺陷描述", requiredMode = Schema.RequiredMode.REQUIRED, example = "Surface scratch")
    @NotEmpty(message = "Defect Description is required.")
    private String name;

    @Schema(description = "缺陷等级", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Defect level is required.")
    @InEnum(MesQcDefectLevelEnum.class)
    private Integer level;

    @Schema(description = "缺陷数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Defect quantity is required.")
    private Integer quantity;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}
