package cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "MES device ledger response VO.")
@Data
@ExcelIgnoreUnannotated
public class MesDvMachineryRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "EQ-001")
    @ExcelProperty("Device Code")
    private String code;

    @Schema(description = "Device name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "CNC center")
    @ExcelProperty("Device Name")
    private String name;

    @Schema(description = "Brand.", example = "Siemens")
    @ExcelProperty("Brand")
    private String brand;

    @Schema(description = "Spec / Model", example = "S7-300")
    @ExcelProperty("Spec / Model")
    private String specification;

    @Schema(description = "Device type code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long machineryTypeId;

    @Schema(description = "Device type name.", example = "CNC machine")
    @ExcelProperty("Device Type")
    private String machineryTypeName;

    @Schema(description = "Workshop code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    private Long workshopId;

    @Schema(description = "Workshop name.", example = "Workshop 1")
    @ExcelProperty("Shop Floor")
    private String workshopName;

    @Schema(description = "Device status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Device Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_DV_MACHINERY_STATUS)
    private Integer status;

    @Schema(description = "Last maintenance time.")
    @ExcelProperty("Last Maintenance Time")
    private LocalDateTime lastMaintenTime;

    @Schema(description = "Last inspection time.")
    @ExcelProperty("Last Inspection Time")
    private LocalDateTime lastCheckTime;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
