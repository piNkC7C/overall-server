package cn.iocoder.yudao.module.mes.controller.admin.pro.workrecord.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Clock-on/off ledger response VO.")
@Data
@Accessors(chain = true)
@ExcelIgnoreUnannotated
public class MesProWorkRecordLogRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "User ID.", example = "1")
    private Long userId;

    @Schema(description = "Nickname", example = "John.")
    @ExcelProperty("Nickname")
    private String userNickname;

    @Schema(description = "Workstation code.", example = "1")
    private Long workstationId;

    @Schema(description = "Workstation code.", example = "WS-001")
    @ExcelProperty("Workstation Code")
    private String workstationCode;

    @Schema(description = "Workstation name.", example = "Injection workstation")
    @ExcelProperty("Workstation Name")
    private String workstationName;

    @Schema(description = "Action type (1 clock in, 2 clock out).", example = "1")
    @ExcelProperty(value = "Action Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_PRO_WORK_RECORD_TYPE)
    private Integer type;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
