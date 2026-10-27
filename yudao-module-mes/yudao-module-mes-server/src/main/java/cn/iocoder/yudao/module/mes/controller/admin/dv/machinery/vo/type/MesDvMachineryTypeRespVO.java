package cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo.type;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES device type response.")
@Data
@ExcelIgnoreUnannotated
public class MesDvMachineryTypeRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Type code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "MT-001")
    @ExcelProperty("Type Code")
    private String code;

    @Schema(description = "Type name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "CNC machine")
    @ExcelProperty("Type Name")
    private String name;

    @Schema(description = "Parent type code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Long parentId;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "Show sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Display Order")
    private Integer sort;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
