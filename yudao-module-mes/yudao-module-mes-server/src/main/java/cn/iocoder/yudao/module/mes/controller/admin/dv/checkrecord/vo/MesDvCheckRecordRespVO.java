package cn.iocoder.yudao.module.mes.controller.admin.dv.checkrecord.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 设备点检记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesDvCheckRecordRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "点检计划编号", example = "1")
    private Long planId;

    @Schema(description = "计划名称", example = "Daily inspection plan")
    @ExcelProperty("Plan Name")
    private String planName;

    @Schema(description = "计划编码", example = "P001")
    @ExcelProperty("Plan Code")
    private String planCode;

    @Schema(description = "开始时间")
    @ExcelProperty("Start Time")
    private LocalDateTime planStartDate;

    @Schema(description = "结束日期")
    @ExcelProperty("End Date")
    private LocalDateTime planEndDate;

    @Schema(description = "频率类型", example = "1")
    @ExcelProperty(value = "Frequency Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_DV_CYCLE_TYPE)
    private Integer planCycleType;

    @Schema(description = "频率数量", example = "5")
    @ExcelProperty(value = "Frequency Count")
    private Integer planCycleCount;

    @Schema(description = "设备编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long machineryId;

    @Schema(description = "设备编码", example = "M001")
    @ExcelProperty("Device Code")
    private String machineryCode;

    @Schema(description = "设备名称", example = "Machine A")
    @ExcelProperty("Device Name")
    private String machineryName;

    @Schema(description = "品牌", example = "Siemens")
    @ExcelProperty("Brand")
    private String machineryBrand;

    @Schema(description = "规格型号", example = "X-100")
    @ExcelProperty("Spec / Model")
    private String machinerySpecification;

    @Schema(description = "点检时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Inspection Time")
    private LocalDateTime checkTime;

    @Schema(description = "点检人编号", example = "1")
    private Long userId;

    @Schema(description = "点检人名称", example = "John.")
    @ExcelProperty("Inspector")
    private String nickname;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_DV_CHECK_RECORD_STATUS)
    private Integer status;

    @Schema(description = "备注", example = "Sample notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
