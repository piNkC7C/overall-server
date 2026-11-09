package cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 设备台账 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesDvMachineryRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "设备编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "EQ-001")
    @ExcelProperty("Device Code")
    private String code;

    @Schema(description = "设备名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "CNC center")
    @ExcelProperty("Device Name")
    private String name;

    @Schema(description = "品牌", example = "Siemens")
    @ExcelProperty("Brand")
    private String brand;

    @Schema(description = "规格型号", example = "S7-300")
    @ExcelProperty("Spec / Model")
    private String specification;

    @Schema(description = "设备类型编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long machineryTypeId;

    @Schema(description = "设备类型名称", example = "CNC machine")
    @ExcelProperty("Device Type")
    private String machineryTypeName;

    @Schema(description = "所属车间编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    private Long workshopId;

    @Schema(description = "所属车间名称", example = "Workshop 1")
    @ExcelProperty("Shop Floor")
    private String workshopName;

    @Schema(description = "设备状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Device Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_DV_MACHINERY_STATUS)
    private Integer status;

    @Schema(description = "最近保养时间")
    @ExcelProperty("Last Maintenance Time")
    private LocalDateTime lastMaintenTime;

    @Schema(description = "最近点检时间")
    @ExcelProperty("Last Inspection Time")
    private LocalDateTime lastCheckTime;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
