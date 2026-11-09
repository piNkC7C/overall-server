package cn.iocoder.yudao.module.mes.controller.admin.tm.tool.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 工具台账 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesTmToolRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "工具编码", example = "T-001")
    @ExcelProperty("Tool Code")
    private String code;

    @Schema(description = "工具名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "5mm end mill")
    @ExcelProperty("Tool Name")
    private String name;

    @Schema(description = "品牌", example = "Mitsubishi")
    @ExcelProperty("Brand")
    private String brand;

    @Schema(description = "型号规格", example = "M5-100")
    @ExcelProperty("Model / Spec")
    private String specification;

    @Schema(description = "工具类型编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long toolTypeId;

    @Schema(description = "工具类型名称", example = "Milling cutter")
    @ExcelProperty("Tool Type")
    private String toolTypeName;

    @Schema(description = "数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Quantity")
    private Integer quantity;

    @Schema(description = "可用数量", example = "1")
    @ExcelProperty("Available Quantity")
    private Integer availableQuantity;

    @Schema(description = "保养维护类型", example = "1")
    @ExcelProperty(value = "Maintenance Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_TM_MAINTEN_TYPE)
    private Integer maintenType;

    @Schema(description = "下次保养周期（次数）", example = "100")
    @ExcelProperty("Next Maintenance Cycle")
    private Integer nextMaintenPeriod;

    @Schema(description = "下次保养日期", example = "2024-06-01 00:00:00")
    @ExcelProperty("Next Maintenance Date")
    private LocalDateTime nextMaintenDate;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_TM_TOOL_STATUS)
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
