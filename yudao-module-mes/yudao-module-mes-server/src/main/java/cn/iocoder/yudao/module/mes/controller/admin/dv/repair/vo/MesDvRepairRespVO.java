package cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES repair work order response.")
@Data
@ExcelIgnoreUnannotated
public class MesDvRepairRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Repair work order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "REP2024001")
    @ExcelProperty("Maintenance Work Order Code")
    private String code;

    @Schema(description = "Repair work order name.", example = "Injection-molding hydraulic repair")
    @ExcelProperty("Maintenance Work Order Name")
    private String name;

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long machineryId;

    @Schema(description = "Device code.", example = "M001")
    @ExcelProperty("Device Code")
    private String machineryCode;

    @Schema(description = "Device name.", example = "Injection-molding machine")
    @ExcelProperty("Device Name")
    private String machineryName;

    @Schema(description = "Brand.", example = "Siemens")
    @ExcelProperty("Brand")
    private String machineryBrand;

    @Schema(description = "Spec / Model", example = "X-100")
    @ExcelProperty("Spec / Model")
    private String machinerySpecification;

    @Schema(description = "Repair date.")
    @ExcelProperty("Repair Request Date")
    private LocalDateTime requireDate;

    @Schema(description = "MaintenancecompleteDate.")
    @ExcelProperty("Repair Completed Date")
    private LocalDateTime finishDate;

    @Schema(description = "Accept Date.")
    @ExcelProperty("Acceptance Date")
    private LocalDateTime confirmDate;

    @Schema(description = "Maintenance result.", example = "1")
    @ExcelProperty(value = "Repair Result", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_DV_REPAIR_RESULT)
    private Integer result;

    @Schema(description = "Maintenance person user ID.", example = "1")
    private Long acceptedUserId;

    @Schema(description = "Maintenance person name.", example = "John.")
    @ExcelProperty("Repairer")
    private String acceptedUserNickname;

    @Schema(description = "Accept person user ID.", example = "1")
    private Long confirmUserId;

    @Schema(description = "Accept person name.", example = "Jane.")
    @ExcelProperty("Accepted By")
    private String confirmUserNickname;

    @Schema(description = "Source document type.", example = "1")
    private Integer sourceDocType;

    @Schema(description = "Source document code.", example = "1")
    private Long sourceDocId;

    @Schema(description = "Source document code.", example = "DOC001")
    private String sourceDocCode;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_DV_REPAIR_STATUS)
    private Integer status;

    @Schema(description = "Notes.", example = "Sample notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
