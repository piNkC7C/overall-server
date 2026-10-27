package cn.iocoder.yudao.module.infra.controller.admin.config.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.infra.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - setting info response.")
@Data
@ExcelIgnoreUnannotated
public class ConfigRespVO {

    @Schema(description = "SettingNo.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Setting Sequence")
    private Long id;

    @Schema(description = "Parameter category.", requiredMode = Schema.RequiredMode.REQUIRED, example = "biz")
    @ExcelProperty("Setting Category")
    private String category;

    @Schema(description = "Parameter name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Database name")
    @ExcelProperty("Setting Name")
    private String name;

    @Schema(description = "Config key", requiredMode = Schema.RequiredMode.REQUIRED, example = "yunai.db.username")
    @ExcelProperty("Setting Key")
    private String key;

    @Schema(description = "Config value", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Setting Value")
    private String value;

    @Schema(description = "Parameter type, see SysConfigTypeEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Setting Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.CONFIG_TYPE)
    private Integer type;

    @Schema(description = "Visible", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty(value = "Visible", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.BOOLEAN_STRING)
    private Boolean visible;

    @Schema(description = "Notes.", example = "Just a cool note!")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Timestamp format.")
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
