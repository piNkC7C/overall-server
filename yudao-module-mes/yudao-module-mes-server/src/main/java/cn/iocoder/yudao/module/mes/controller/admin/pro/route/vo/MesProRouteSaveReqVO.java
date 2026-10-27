package cn.iocoder.yudao.module.mes.controller.admin.pro.route.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Schema(description = "Admin - MES routing path create / edit request.")
@Data
public class MesProRouteSaveReqVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Routing path code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ROUTE001")
    @NotBlank(message = "Routing path code is required.")
    private String code;

    @Schema(description = "Routing path name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Standard path.")
    @NotBlank(message = "Routing path name is required.")
    private String name;

    @Schema(description = "Routing pathNotes.")
    private String description;

    @Schema(description = "Notes.")
    private String remark;

}
