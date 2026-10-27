package cn.iocoder.yudao.module.mes.controller.admin.qc.template.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - MES quality inspection plan response.")
@Data
@ExcelIgnoreUnannotated
public class MesQcTemplateRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "QCT001")
    @ExcelProperty("Plan ID")
    private String code;

    @Schema(description = "Plan name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Finished-goods outgoing inspection plan")
    @ExcelProperty("Plan Name")
    private String name;

    @Schema(description = "Inspection Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 3]")
    @ExcelProperty("Check Type")
    private List<Integer> types;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
