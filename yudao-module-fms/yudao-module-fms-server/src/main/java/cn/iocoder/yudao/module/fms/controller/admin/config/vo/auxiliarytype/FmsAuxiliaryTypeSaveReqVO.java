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
@Schema(description = "管理后台 - FMS 辅助核算类别创建或修改 Request VO")
@Data
public class FmsAuxiliaryTypeSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Store")
    @NotBlank(message = "Name is required.")
    @Size(max = 255, message = "Name length cannot exceed 255 characters.")
    private String name;

}
