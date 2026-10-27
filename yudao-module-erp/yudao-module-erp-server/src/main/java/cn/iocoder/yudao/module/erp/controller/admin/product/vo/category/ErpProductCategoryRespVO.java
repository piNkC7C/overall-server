package cn.iocoder.yudao.module.erp.controller.admin.product.vo.category;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - ERP product category response.")
@Data
@ExcelIgnoreUnannotated
public class ErpProductCategoryRespVO {

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5860")
    @ExcelProperty("Category ID")
    private Long id;

    @Schema(description = "Parent category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "21829")
    @ExcelProperty("Parent Category ID")
    private Long parentId;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @ExcelProperty("Category Name")
    private String name;

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "S110")
    @ExcelProperty("Category Code")
    private String code;

    @Schema(description = "Category sort.", example = "10")
    @ExcelProperty("Category Sort")
    private Integer sort;

    @Schema(description = "Enable status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Enabled", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}