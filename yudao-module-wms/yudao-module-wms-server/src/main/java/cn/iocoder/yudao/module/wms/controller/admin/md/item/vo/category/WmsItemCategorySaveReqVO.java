package cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.category;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - WMS 商品分类新增/修改 Request VO")
@Data
public class WmsItemCategorySaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "父级编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Parent code is required.")
    private Long parentId;

    @Schema(description = "分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "C00000001")
    @NotEmpty(message = "Category code is required.")
    @Size(max = 20, message = "Category code length cannot exceed 20 characters.")
    private String code;

    @Schema(description = "分类名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw material")
    @NotEmpty(message = "Category name is required.")
    @Size(max = 30, message = "Category name length cannot exceed 30 characters.")
    private String name;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status;

}
