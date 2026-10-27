package cn.iocoder.yudao.module.system.controller.admin.dept.vo.post;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - post info response.")
@Data
@ExcelIgnoreUnannotated
public class PostRespVO {

    @Schema(description = "Post No.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Job Title Sequence")
    private Long id;

    @Schema(description = "Post name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Potato")
    @ExcelProperty("Job Title")
    private String name;

    @Schema(description = "Post code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    @ExcelProperty("Job Title Code")
    private String code;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Job Title Sort")
    private Integer sort;

    @Schema(description = "Status, see CommonStatusEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "Notes.", example = "Happy note")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
