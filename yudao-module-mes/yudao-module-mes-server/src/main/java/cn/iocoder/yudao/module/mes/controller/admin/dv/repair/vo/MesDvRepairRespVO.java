package cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 维修工单 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesDvRepairRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "维修工单编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "REP2024001")
    @ExcelProperty("Maintenance Work Order Code")
    private String code;

    @Schema(description = "维修工单名称", example = "Injection-molding hydraulic repair")
    @ExcelProperty("Maintenance Work Order Name")
    private String name;

    @Schema(description = "设备编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long machineryId;

    @Schema(description = "设备编码", example = "M001")
    @ExcelProperty("Device Code")
    private String machineryCode;

    @Schema(description = "设备名称", example = "Injection-molding machine")
    @ExcelProperty("Device Name")
    private String machineryName;

    @Schema(description = "品牌", example = "Siemens")
    @ExcelProperty("Brand")
    private String machineryBrand;

    @Schema(description = "规格型号", example = "X-100")
    @ExcelProperty("Spec / Model")
    private String machinerySpecification;

    @Schema(description = "报修日期")
    @ExcelProperty("Repair Request Date")
    private LocalDateTime requireDate;

    @Schema(description = "维修完成日期")
    @ExcelProperty("Repair Completed Date")
    private LocalDateTime finishDate;

    @Schema(description = "验收日期")
    @ExcelProperty("Acceptance Date")
    private LocalDateTime confirmDate;

    @Schema(description = "维修结果", example = "1")
    @ExcelProperty(value = "Repair Result", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_DV_REPAIR_RESULT)
    private Integer result;

    @Schema(description = "维修人用户编号", example = "1")
    private Long acceptedUserId;

    @Schema(description = "维修人名称", example = "John.")
    @ExcelProperty("Repairer")
    private String acceptedUserNickname;

    @Schema(description = "验收人用户编号", example = "1")
    private Long confirmUserId;

    @Schema(description = "验收人名称", example = "Jane.")
    @ExcelProperty("Accepted By")
    private String confirmUserNickname;

    @Schema(description = "来源单据类型", example = "1")
    private Integer sourceDocType;

    @Schema(description = "来源单据编号", example = "1")
    private Long sourceDocId;

    @Schema(description = "来源单据编码", example = "DOC001")
    private String sourceDocCode;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_DV_REPAIR_STATUS)
    private Integer status;

    @Schema(description = "备注", example = "Sample notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
