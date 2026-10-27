package cn.iocoder.yudao.module.mes.controller.admin.pro.process.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES production operation response.")
@Data
public class MesProProcessRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Operation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "PROCESS001")
    private String code;

    @Schema(description = "Operation name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cutting operation")
    private String name;

    @Schema(description = "Routing require.", example = "Cut to the drawing size")
    private String attention;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Notes.", example = "Sheet-metal cutting")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
