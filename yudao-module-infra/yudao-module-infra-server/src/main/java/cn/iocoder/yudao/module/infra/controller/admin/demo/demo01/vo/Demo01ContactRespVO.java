package cn.iocoder.yudao.module.infra.controller.admin.demo.demo01.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - sample contact response.")
@Data
@ExcelIgnoreUnannotated
public class Demo01ContactRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "21555")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    @ExcelProperty("Name")
    private String name;

    @Schema(description = "Gender", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Gender", converter = DictConvert.class)
    @DictFormat("system_user_sex") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer sex;

    @Schema(description = "Birth year", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Birth Year")
    private LocalDateTime birthday;

    @Schema(description = "Bio.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Looks good.")
    @ExcelProperty("Summary")
    private String description;

    @Schema(description = "Avatar")
    @ExcelProperty("Avatar")
    private String avatar;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}