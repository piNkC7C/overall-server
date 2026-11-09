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

@Schema(description = "管理后台 - ERP 仓库 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ErpWarehouseRespVO {

    @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "11614")
    @ExcelProperty("Warehouse Code")
    private Long id;

    @Schema(description = "仓库名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @ExcelProperty("Warehouse Name")
    private String name;

    @Schema(description = "仓库地址", example = "Downtown Seattle")
    @ExcelProperty("Warehouse Address")
    private String address;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @ExcelProperty("Sort")
    private Long sort;

    @Schema(description = "备注", example = "Sample.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "负责人", example = "Taro")
    @ExcelProperty("Owner")
    private String principal;

    @Schema(description = "仓储费，单位：元", example = "13973")
    @ExcelProperty("Storage Fee, In Dollars")
    private BigDecimal warehousePrice;

    @Schema(description = "搬运费，单位：元", example = "9903")
    @ExcelProperty("Handling Fee, In Dollars")
    private BigDecimal truckagePrice;

    @Schema(description = "开启状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Enabled", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "是否默认", example = "1")
    @ExcelProperty("Default")
    private Boolean defaultStatus;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}