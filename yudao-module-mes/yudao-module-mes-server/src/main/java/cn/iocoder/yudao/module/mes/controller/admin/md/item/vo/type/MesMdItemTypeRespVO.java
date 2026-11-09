package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.type;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 物料产品分类 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesMdItemTypeRespVO {

    @Schema(description = "分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Category ID")
    private Long id;

    @Schema(description = "父分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Parent Category ID")
    private Long parentId;

    @Schema(description = "分类编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "RAW")
    @ExcelProperty("Category Code")
    private String code;

    @Schema(description = "分类名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw material")
    @ExcelProperty("Category Name")
    private String name;

    @Schema(description = "物料/产品标识", requiredMode = Schema.RequiredMode.REQUIRED, example = "ITEM")
    @ExcelProperty("Material / Product Key")
    private String itemOrProduct;

    @Schema(description = "显示排序", example = "0")
    @ExcelProperty("Display Order")
    private Integer sort;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
