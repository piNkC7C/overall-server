package cn.iocoder.yudao.module.infra.controller.admin.demo.demo03.inner.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 学生 Response VO")
@Data
@ExcelIgnoreUnannotated
public class Demo03StudentInnerRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "8525")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @ExcelProperty("Name")
    private String name;

    @Schema(description = "性别", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "Gender", converter = DictConvert.class)
    @DictFormat("system_user_sex") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer sex;

    @Schema(description = "出生日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Date Of Birth")
    private LocalDateTime birthday;

    @Schema(description = "简介", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sample.")
    @ExcelProperty("Summary")
    private String description;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}