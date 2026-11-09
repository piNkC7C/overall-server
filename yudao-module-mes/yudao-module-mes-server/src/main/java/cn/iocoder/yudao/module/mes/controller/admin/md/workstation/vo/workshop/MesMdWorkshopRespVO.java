package cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo.workshop;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 车间 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesMdWorkshopRespVO {

    @Schema(description = "车间编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Shop Floor ID")
    private Long id;

    @Schema(description = "车间编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "WS001")
    @ExcelProperty("Shop Floor Code")
    private String code;

    @Schema(description = "车间名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Workshop 1")
    @ExcelProperty("Shop Floor Name")
    private String name;

    @Schema(description = "面积", example = "1000.00")
    @ExcelProperty("Area")
    private BigDecimal area;

    @Schema(description = "负责人用户编号", example = "1")
    private Long chargeUserId;

    @Schema(description = "负责人名称", example = "John.")
    @ExcelProperty("Owner")
    private String chargeUserName;

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
