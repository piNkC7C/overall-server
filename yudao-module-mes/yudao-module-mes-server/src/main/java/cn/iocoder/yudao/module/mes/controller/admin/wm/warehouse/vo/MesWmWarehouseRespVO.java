package cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 仓库 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesWmWarehouseRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "仓库编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "WH001")
    @ExcelProperty("Warehouse Code")
    private String code;

    @Schema(description = "仓库名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw Materials.")
    @ExcelProperty("Warehouse Name")
    private String name;

    @Schema(description = "仓库地址", example = "Building 1, Zone A")
    @ExcelProperty("Warehouse Address")
    private String address;

    @Schema(description = "面积", example = "1200.50")
    @ExcelProperty("Area")
    private BigDecimal area;

    @Schema(description = "负责人用户编号", example = "1")
    private Long chargeUserId;

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
