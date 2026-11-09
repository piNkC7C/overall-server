package cn.iocoder.yudao.module.mes.controller.admin.pro.route.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 工艺路线 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesProRouteRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "工艺路线编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "ROUTE001")
    @ExcelProperty("Routing Code")
    private String code;

    @Schema(description = "工艺路线名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Standard path.")
    @ExcelProperty("Routing Name")
    private String name;

    @Schema(description = "工艺路线说明")
    @ExcelProperty("Routing Notes")
    private String description;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
