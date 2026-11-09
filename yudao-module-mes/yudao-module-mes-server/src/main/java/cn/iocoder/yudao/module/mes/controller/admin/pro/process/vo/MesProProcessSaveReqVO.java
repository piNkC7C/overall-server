package cn.iocoder.yudao.module.mes.controller.admin.pro.process.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - MES 生产工序新增/修改 Request VO")
@Data
public class MesProProcessSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @Schema(description = "工序编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "PROCESS001")
    @NotBlank(message = "Operation code is required.")
    private String code;

    @Schema(description = "工序名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cutting operation")
    @NotBlank(message = "Operation name is required.")
    private String name;

    @Schema(description = "工艺要求", example = "Cut to the drawing size")
    private String attention;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "备注", example = "Sheet-metal cutting")
    private String remark;

}
