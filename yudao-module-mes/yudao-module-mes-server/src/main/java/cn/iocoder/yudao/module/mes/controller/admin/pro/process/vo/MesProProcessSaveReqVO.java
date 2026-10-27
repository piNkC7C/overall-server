package cn.iocoder.yudao.module.mes.controller.admin.pro.process.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES production operation create / edit request.")
@Data
public class MesProProcessSaveReqVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Operation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "PROCESS001")
    @NotBlank(message = "Operation code is required.")
    private String code;

    @Schema(description = "Operation name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cutting operation")
    @NotBlank(message = "Operation name is required.")
    private String name;

    @Schema(description = "Routing require.", example = "Cut to the drawing size")
    private String attention;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Notes.", example = "Sheet-metal cutting")
    private String remark;

}
