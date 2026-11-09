package cn.iocoder.yudao.module.mes.controller.admin.qc.template.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - MES 质检方案 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesQcTemplateRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "方案编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "QCT001")
    @ExcelProperty("Plan ID")
    private String code;

    @Schema(description = "方案名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Finished-goods outgoing inspection plan")
    @ExcelProperty("Plan Name")
    private String name;

    @Schema(description = "检测种类", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 3]")
    @ExcelProperty("Check Type")
    private List<Integer> types;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
