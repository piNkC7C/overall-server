package cn.iocoder.yudao.module.fms.controller.admin.config.vo.auxiliaryitem;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * FMS 辅助核算项目创建或修改 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - FMS auxiliary accounting item create or edit request.")
@Data
public class FmsAuxiliaryItemSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Auxiliary category ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Auxiliary category ID is required.")
    private Long auxiliaryTypeId;

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "KH001")
    @NotBlank(message = "Code is required.")
    @Size(max = 64, message = "Code length cannot exceed 64 characters.")
    private String code;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Seattle Sample Digital LLC")
    @NotBlank(message = "Name is required.")
    @Size(max = 255, message = "Name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "Notes.", example = "Key customer")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

    @Schema(description = "SKU.", example = "Standard edition")
    @Size(max = 255, message = "SKU length cannot exceed 255 characters.")
    private String specification;

    @Schema(description = "Order characters.", example = "Unit")
    @Size(max = 255, message = "Order characters length cannot exceed 255 characters.")
    private String unit;

}
