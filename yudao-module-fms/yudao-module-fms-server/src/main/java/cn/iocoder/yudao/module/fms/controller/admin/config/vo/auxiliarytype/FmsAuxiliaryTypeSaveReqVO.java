package cn.iocoder.yudao.module.fms.controller.admin.config.vo.auxiliarytype;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * FMS 辅助核算类别创建或修改 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "FMS Auxiliary accountingCategory create update request VO.")
@Data
public class FmsAuxiliaryTypeSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Store")
    @NotBlank(message = "Name is required.")
    @Size(max = 255, message = "Name length cannot exceed 255 characters.")
    private String name;

}
