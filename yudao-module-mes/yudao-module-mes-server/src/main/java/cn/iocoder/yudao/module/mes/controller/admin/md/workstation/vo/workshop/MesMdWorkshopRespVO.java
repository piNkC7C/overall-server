package cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo.workshop;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES workshop response.")
@Data
@ExcelIgnoreUnannotated
public class MesMdWorkshopRespVO {

    @Schema(description = "Workshop code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Shop Floor ID")
    private Long id;

    @Schema(description = "Workshop code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WS001")
    @ExcelProperty("Shop Floor Code")
    private String code;

    @Schema(description = "Workshop name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Workshop 1")
    @ExcelProperty("Shop Floor Name")
    private String name;

    @Schema(description = "Area", example = "1000.00")
    @ExcelProperty("Area")
    private BigDecimal area;

    @Schema(description = "Owner person user ID.", example = "1")
    private Long chargeUserId;

    @Schema(description = "Owner person name.", example = "John.")
    @ExcelProperty("Owner")
    private String chargeUserName;

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
