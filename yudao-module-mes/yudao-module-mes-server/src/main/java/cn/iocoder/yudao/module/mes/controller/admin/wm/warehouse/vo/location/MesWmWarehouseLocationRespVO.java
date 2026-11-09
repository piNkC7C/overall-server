package cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo.location;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 库区 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesWmWarehouseLocationRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "库区编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "L001")
    @ExcelProperty("Zone Code")
    private String code;

    @Schema(description = "库区名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw-material zone")
    @ExcelProperty("Zone Name")
    private String name;

    @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long warehouseId;

    @Schema(description = "仓库名称", example = "Raw Materials.")
    @ExcelProperty("Warehouse Name")
    private String warehouseName;

    @Schema(description = "面积", example = "500.00")
    @ExcelProperty("Area")
    private BigDecimal area;

    @Schema(description = "是否冻结", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @ExcelProperty("Frozen")
    private Boolean frozen;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
