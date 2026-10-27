package cn.iocoder.yudao.module.infra.controller.admin.demo.demo02.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - sample category response.")
@Data
@ExcelIgnoreUnannotated
public class Demo02CategoryRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10304")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @ExcelProperty("Name")
    private String name;

    @Schema(description = "Parent code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "6080")
    @ExcelProperty("Parent ID")
    private Long parentId;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}