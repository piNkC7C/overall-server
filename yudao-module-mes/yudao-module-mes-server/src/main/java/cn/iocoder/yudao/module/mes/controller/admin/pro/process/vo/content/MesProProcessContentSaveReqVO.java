package cn.iocoder.yudao.module.mes.controller.admin.pro.process.vo.content;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES production operation content create / edit request.")
@Data
public class MesProProcessContentSaveReqVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Operation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Operation code is required.")
    private Long processId;

    @Schema(description = "Order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Order code is required.")
    private Integer sort;

    @Schema(description = "Step notes.", example = "Check whether welding equipment is normal")
    private String content;

    @Schema(description = "Auxiliary equipment.", example = "TIG welder")
    private String device;

    @Schema(description = "Auxiliary material.", example = "ER308 welding wire")
    private String material;

    @Schema(description = "Material document URL.", example = "https://example.com/doc.pdf")
    private String docUrl;

    @Schema(description = "Notes.", example = "Stay safe")
    private String remark;

}
