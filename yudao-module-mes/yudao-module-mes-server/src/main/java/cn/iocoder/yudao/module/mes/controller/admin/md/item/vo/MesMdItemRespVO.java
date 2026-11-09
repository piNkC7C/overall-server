package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 物料产品 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesMdItemRespVO {

    @Schema(description = "物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Material ID")
    private Long id;

    @Schema(description = "物料编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "ITEM001")
    @ExcelProperty("Material Code")
    private String code;

    @Schema(description = "物料名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Screw")
    @ExcelProperty("Material Name")
    private String name;

    @Schema(description = "规格型号", example = "M6*20")
    @ExcelProperty("Spec / Model")
    private String specification;

    @Schema(description = "计量单位编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "202")
    private Long unitMeasureId;
    @Schema(description = "计量单位名称", example = "")
    @ExcelProperty("Unit Of Measure")
    private String unitMeasureName;

    @Schema(description = "物料分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemTypeId;
    @Schema(description = "物料分类名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw material")
    @ExcelProperty("Material Category")
    private String itemTypeName;

    @Schema(description = "物料/产品标识", example = "ITEM")
    @ExcelProperty("Material / Product Key")
    private String itemOrProduct;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "是否启用安全库存", example = "false")
    @ExcelProperty("Safety Stock Enabled")
    private Boolean safeStockFlag;

    @Schema(description = "最低库存量", example = "100.0000")
    @ExcelProperty("Min Stock")
    private BigDecimal minStock;

    @Schema(description = "最高库存量", example = "10000.0000")
    @ExcelProperty("Max Stock")
    private BigDecimal maxStock;

    @Schema(description = "是否高值物料", example = "false")
    @ExcelProperty("High-value Material")
    private Boolean highValue;

    @Schema(description = "是否启用批次管理", example = "true")
    @ExcelProperty("Lot Control Enabled")
    private Boolean batchFlag;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
