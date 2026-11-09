package cn.iocoder.yudao.module.infra.controller.admin.config.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.infra.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 参数配置信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ConfigRespVO {

    @Schema(description = "参数配置序号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Setting Sequence")
    private Long id;

    @Schema(description = "参数分类", requiredMode = Schema.RequiredMode.REQUIRED, example = "biz")
    @ExcelProperty("Setting Category")
    private String category;

    @Schema(description = "参数名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Database name")
    @ExcelProperty("Setting Name")
    private String name;

    @Schema(description = "参数键名", requiredMode = Schema.RequiredMode.REQUIRED, example = "yunai.db.username")
    @ExcelProperty("Setting Key")
    private String key;

    @Schema(description = "参数键值", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Setting Value")
    private String value;

    @Schema(description = "参数类型，参见 SysConfigTypeEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Setting Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.CONFIG_TYPE)
    private Integer type;

    @Schema(description = "是否可见", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty(value = "Visible", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.BOOLEAN_STRING)
    private Boolean visible;

    @Schema(description = "备注", example = "Just a cool note!")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "Timestamp format.")
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
