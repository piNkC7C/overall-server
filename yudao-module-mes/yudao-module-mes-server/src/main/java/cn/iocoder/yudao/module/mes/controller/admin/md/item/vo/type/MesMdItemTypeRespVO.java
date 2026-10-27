package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.type;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES material product category response.")
@Data
@ExcelIgnoreUnannotated
public class MesMdItemTypeRespVO {

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Category ID")
    private Long id;

    @Schema(description = "Parent category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Parent Category ID")
    private Long parentId;

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "RAW")
    @ExcelProperty("Category Code")
    private String code;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw material")
    @ExcelProperty("Category Name")
    private String name;

    @Schema(description = "Material /product key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ITEM")
    @ExcelProperty("Material / Product Key")
    private String itemOrProduct;

    @Schema(description = "Show sort.", example = "0")
    @ExcelProperty("Display Order")
    private Integer sort;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
