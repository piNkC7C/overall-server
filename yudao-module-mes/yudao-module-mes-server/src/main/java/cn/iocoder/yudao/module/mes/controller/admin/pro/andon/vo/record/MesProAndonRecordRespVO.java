package cn.iocoder.yudao.module.mes.controller.admin.pro.andon.vo.record;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "MES andon call record response VO.")
@Data
@ExcelIgnoreUnannotated
public class MesProAndonRecordRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Andon settingID.", example = "1")
    private Long configId;

    @Schema(description = "Workstation code.", example = "100")
    private Long workstationId;

    @Schema(description = "Workstation code.", example = "WS-001")
    @ExcelProperty("Workstation Code")
    private String workstationCode;

    @Schema(description = "Workstation name.", example = "Workstation A.")
    @ExcelProperty("Workstation Name")
    private String workstationName;

    @Schema(description = "Start user ID.", example = "1")
    private Long userId;

    @Schema(description = "Start person Nickname.", example = "John.")
    @ExcelProperty("Starter")
    private String userNickname;

    @Schema(description = "Production work order code.", example = "200")
    private Long workOrderId;

    @Schema(description = "Work order code.", example = "WO-001")
    @ExcelProperty("Work Order Code")
    private String workOrderCode;

    @Schema(description = "Operation code.", example = "300")
    private Long processId;

    @Schema(description = "Operation name.", example = "Assembly operation")
    @ExcelProperty("Operation Name")
    private String processName;

    @Schema(description = "Call Reason", example = "Equipment fault")
    @ExcelProperty("Call Reason")
    private String reason;

    @Schema(description = "Level.", example = "1")
    @ExcelProperty(value = "Level", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_PRO_ANDON_LEVEL)
    private Integer level;

    @Schema(description = "Handle status.", example = "0")
    @ExcelProperty(value = "Handling Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_PRO_ANDON_STATUS)
    private Integer status;

    @Schema(description = "Handle time.")
    @ExcelProperty("Handled Time")
    private LocalDateTime handleTime;

    @Schema(description = "Handle person code.", example = "100")
    private Long handlerUserId;

    @Schema(description = "Handle person Nickname.", example = "Jane.")
    @ExcelProperty("Handler")
    private String handlerUserNickname;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Start Time")
    private LocalDateTime createTime;

}
