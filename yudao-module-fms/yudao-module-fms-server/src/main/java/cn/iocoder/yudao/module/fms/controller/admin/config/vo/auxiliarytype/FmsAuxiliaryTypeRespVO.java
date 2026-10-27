package cn.iocoder.yudao.module.fms.controller.admin.config.vo.auxiliarytype;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * FMS 辅助核算类别 Response VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - FMS Auxiliary accounting type response.")
@Data
public class FmsAuxiliaryTypeRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Customer.")
    private String name;

    @Schema(description = "System preset.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean systemPreset;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long accountSetId;

    @Schema(description = "Type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

}
