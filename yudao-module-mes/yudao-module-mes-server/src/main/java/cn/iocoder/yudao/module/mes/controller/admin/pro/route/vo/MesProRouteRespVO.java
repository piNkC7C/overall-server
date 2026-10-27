package cn.iocoder.yudao.module.mes.controller.admin.pro.route.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES routing path response.")
@Data
@ExcelIgnoreUnannotated
public class MesProRouteRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Routing path code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ROUTE001")
    @ExcelProperty("Routing Code")
    private String code;

    @Schema(description = "Routing path name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Standard path.")
    @ExcelProperty("Routing Name")
    private String name;

    @Schema(description = "Routing pathNotes.")
    @ExcelProperty("Routing Notes")
    private String description;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
