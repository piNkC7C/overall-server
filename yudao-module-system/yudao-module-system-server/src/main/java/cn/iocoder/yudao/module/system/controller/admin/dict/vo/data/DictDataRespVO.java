package cn.iocoder.yudao.module.system.controller.admin.dict.vo.data;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - dictionary data info response.")
@Data
@ExcelIgnoreUnannotated
public class DictDataRespVO {

    @Schema(description = "Dictionary data code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Dictionary Code")
    private Long id;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Dictionary Sort")
    private Integer sort;

    @Schema(description = "Dictionarytag.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @ExcelProperty("Dictionary Label")
    private String label;

    @Schema(description = "Dictionary value.", requiredMode = Schema.RequiredMode.REQUIRED, example = "iocoder")
    @ExcelProperty("Dictionary Value")
    private String value;

    @Schema(description = "Dictionary type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "sys_common_sex")
    @ExcelProperty("Dictionary Type")
    private String dictType;

    @Schema(description = "Status. See CommonStatusEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "Color type,default、primary、success、info、warning、danger.", example = "default")
    private String colorType;

    @Schema(description = "CSS class", example = "btn-visible")
    private String cssClass;

    @Schema(description = "Notes.", example = "Me is one role.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Timestamp format.")
    private LocalDateTime createTime;

}
