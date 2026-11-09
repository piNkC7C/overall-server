package cn.iocoder.yudao.module.erp.controller.admin.product.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - ERP 产品分类新增/修改 Request VO")
@Data
public class ErpProductCategorySaveReqVO {

    @Schema(description = "分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "5860")
    private Long id;

    @Schema(description = "父分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "21829")
    @NotNull(message = "Parent category code is required.")
    private Long parentId;

    @Schema(description = "分类名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotEmpty(message = "Category name is required.")
    private String name;

    @Schema(description = "分类编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "S110")
    @NotEmpty(message = "Category code is required.")
    private String code;

    @Schema(description = "分类排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Category sort is required.")
    private Integer sort;

    @Schema(description = "开启状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Enable status is required.")
    private Integer status;

}