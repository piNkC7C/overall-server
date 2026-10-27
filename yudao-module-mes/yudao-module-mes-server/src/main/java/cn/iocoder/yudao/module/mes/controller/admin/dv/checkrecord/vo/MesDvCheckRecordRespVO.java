package cn.iocoder.yudao.module.mes.controller.admin.dv.checkrecord.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES device inspection record response.")
@Data
@ExcelIgnoreUnannotated
public class MesDvCheckRecordRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Inspection plan code.", example = "1")
    private Long planId;

    @Schema(description = "Plan name.", example = "Daily inspection plan")
    @ExcelProperty("Plan Name")
    private String planName;

    @Schema(description = "Plan code.", example = "P001")
    @ExcelProperty("Plan Code")
    private String planCode;

    @Schema(description = "Start time.")
    @ExcelProperty("Start Time")
    private LocalDateTime planStartDate;

    @Schema(description = "End Date.")
    @ExcelProperty("End Date")
    private LocalDateTime planEndDate;

    @Schema(description = "Frequency type.", example = "1")
    @ExcelProperty(value = "Frequency Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_DV_CYCLE_TYPE)
    private Integer planCycleType;

    @Schema(description = "Frequency count.", example = "5")
    @ExcelProperty(value = "Frequency Count")
    private Integer planCycleCount;

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long machineryId;

    @Schema(description = "Device code.", example = "M001")
    @ExcelProperty("Device Code")
    private String machineryCode;

    @Schema(description = "Device name.", example = "Machine A")
    @ExcelProperty("Device Name")
    private String machineryName;

    @Schema(description = "Brand.", example = "Siemens")
    @ExcelProperty("Brand")
    private String machineryBrand;

    @Schema(description = "Spec / Model", example = "X-100")
    @ExcelProperty("Spec / Model")
    private String machinerySpecification;

    @Schema(description = "Inspection time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Inspection Time")
    private LocalDateTime checkTime;

    @Schema(description = "Inspection person code.", example = "1")
    private Long userId;

    @Schema(description = "Inspection person name.", example = "John.")
    @ExcelProperty("Inspector")
    private String nickname;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_DV_CHECK_RECORD_STATUS)
    private Integer status;

    @Schema(description = "Notes.", example = "Sample notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
