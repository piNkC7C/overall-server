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
@Schema(description = "管理后台 - FMS 辅助核算项目创建或修改 Request VO")
@Data
public class FmsAuxiliaryItemSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "辅助核算类别编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Auxiliary category ID is required.")
    private Long auxiliaryTypeId;

    @Schema(description = "编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "KH001")
    @NotBlank(message = "Code is required.")
    @Size(max = 64, message = "Code length cannot exceed 64 characters.")
    private String code;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Seattle Sample Digital LLC")
    @NotBlank(message = "Name is required.")
    @Size(max = 255, message = "Name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "备注", example = "Key customer")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

    @Schema(description = "规格", example = "Standard edition")
    @Size(max = 255, message = "SKU length cannot exceed 255 characters.")
    private String specification;

    @Schema(description = "单位", example = "Unit")
    @Size(max = 255, message = "Order characters length cannot exceed 255 characters.")
    private String unit;

}
