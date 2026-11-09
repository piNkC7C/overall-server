package cn.iocoder.yudao.module.mes.controller.admin.qc.indicator.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - MES 质检指标新增/修改 Request VO")
@Data
public class MesQcIndicatorSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "检测项编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "QI001")
    @NotEmpty(message = "Inspect item code is required.")
    private String code;

    @Schema(description = "检测项名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Length.")
    @NotEmpty(message = "Inspect item name is required.")
    private String name;

    @Schema(description = "检测项类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inspect item type is required.")
    private Integer type;

    @Schema(description = "检测工具", example = "Caliper")
    private String tool;

    @Schema(description = "结果值类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Result value type cannot be empty.")
    private Integer resultType;

    @Schema(description = "结果值属性", example = "IMG")
    private String resultSpecification;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

    }
