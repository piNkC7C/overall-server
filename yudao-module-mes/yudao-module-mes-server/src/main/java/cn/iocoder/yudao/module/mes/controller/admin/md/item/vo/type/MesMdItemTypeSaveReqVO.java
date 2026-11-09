package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.type;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - MES 物料产品分类新增/修改 Request VO")
@Data
public class MesMdItemTypeSaveReqVO {

    @Schema(description = "分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "父分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Parent category code is required.")
    private Long parentId;

    @Schema(description = "分类编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "RAW")
    @NotEmpty(message = "Category code is required.")
    private String code;

    @Schema(description = "分类名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw material")
    @NotEmpty(message = "Category name is required.")
    private String name;

    @Schema(description = "物料/产品标识", requiredMode = Schema.RequiredMode.REQUIRED, example = "ITEM")
    @NotEmpty(message = "Material /product key is required.")
    private String itemOrProduct;

    @Schema(description = "显示排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Show sort is required.")
    private Integer sort;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

    }
