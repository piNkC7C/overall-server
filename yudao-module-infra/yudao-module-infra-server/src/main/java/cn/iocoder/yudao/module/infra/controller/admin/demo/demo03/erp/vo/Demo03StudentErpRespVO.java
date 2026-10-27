package cn.iocoder.yudao.module.infra.controller.admin.demo.demo03.erp.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - student response.")
@Data
@ExcelIgnoreUnannotated
public class Demo03StudentErpRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8525")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @ExcelProperty("Name")
    private String name;

    @Schema(description = "Gender", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "Gender", converter = DictConvert.class)
    @DictFormat("system_user_sex") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer sex;

    @Schema(description = "Date of birth", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Date Of Birth")
    private LocalDateTime birthday;

    @Schema(description = "Bio.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sample.")
    @ExcelProperty("Summary")
    private String description;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}