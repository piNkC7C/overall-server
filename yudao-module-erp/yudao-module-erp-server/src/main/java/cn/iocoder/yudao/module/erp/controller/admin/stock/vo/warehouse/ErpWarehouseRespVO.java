package cn.iocoder.yudao.module.erp.controller.admin.stock.vo.warehouse;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - ERP warehouse response.")
@Data
@ExcelIgnoreUnannotated
public class ErpWarehouseRespVO {

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11614")
    @ExcelProperty("Warehouse Code")
    private Long id;

    @Schema(description = "Warehouse name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @ExcelProperty("Warehouse Name")
    private String name;

    @Schema(description = "WarehouseAddress.", example = "Downtown Seattle")
    @ExcelProperty("Warehouse Address")
    private String address;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @ExcelProperty("Sort")
    private Long sort;

    @Schema(description = "Notes.", example = "Sample.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Owner person.", example = "Taro")
    @ExcelProperty("Owner")
    private String principal;

    @Schema(description = "Storage Fee, in yuan.", example = "13973")
    @ExcelProperty("Storage Fee, In Dollars")
    private BigDecimal warehousePrice;

    @Schema(description = "Handling Fee, in yuan.", example = "9903")
    @ExcelProperty("Handling Fee, In Dollars")
    private BigDecimal truckagePrice;

    @Schema(description = "Enable status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Enabled", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "Is not default.", example = "1")
    @ExcelProperty("Default")
    private Boolean defaultStatus;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}