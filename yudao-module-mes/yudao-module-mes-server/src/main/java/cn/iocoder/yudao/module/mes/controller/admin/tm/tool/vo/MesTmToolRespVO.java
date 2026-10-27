package cn.iocoder.yudao.module.mes.controller.admin.tm.tool.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "MES tool ledger response VO.")
@Data
@ExcelIgnoreUnannotated
public class MesTmToolRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Tool code.", example = "T-001")
    @ExcelProperty("Tool Code")
    private String code;

    @Schema(description = "Tool name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5mm end mill")
    @ExcelProperty("Tool Name")
    private String name;

    @Schema(description = "Brand.", example = "Mitsubishi")
    @ExcelProperty("Brand")
    private String brand;

    @Schema(description = "Model / Spec", example = "M5-100")
    @ExcelProperty("Model / Spec")
    private String specification;

    @Schema(description = "Tool type code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long toolTypeId;

    @Schema(description = "Tool type name.", example = "Milling cutter")
    @ExcelProperty("Tool Type")
    private String toolTypeName;

    @Schema(description = "Quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Quantity")
    private Integer quantity;

    @Schema(description = "Can quantity.", example = "1")
    @ExcelProperty("Available Quantity")
    private Integer availableQuantity;

    @Schema(description = "Maintenance Type", example = "1")
    @ExcelProperty(value = "Maintenance Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_TM_MAINTEN_TYPE)
    private Integer maintenType;

    @Schema(description = "Next maintenance cycle (count).", example = "100")
    @ExcelProperty("Next Maintenance Cycle")
    private Integer nextMaintenPeriod;

    @Schema(description = "Times maintenance Date.", example = "2024-06-01 00:00:00")
    @ExcelProperty("Next Maintenance Date")
    private LocalDateTime nextMaintenDate;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_TM_TOOL_STATUS)
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
