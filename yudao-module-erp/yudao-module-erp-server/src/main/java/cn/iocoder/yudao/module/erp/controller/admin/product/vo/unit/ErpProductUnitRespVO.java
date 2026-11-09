package cn.iocoder.yudao.module.erp.controller.admin.product.vo.unit;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - ERP 产品单位 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ErpProductUnitRespVO {

    @Schema(description = "单位编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "31254")
    @ExcelProperty("Unit ID")
    private Long id;

    @Schema(description = "单位名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @ExcelProperty("Unit Name")
    private String name;

    @Schema(description = "单位状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Unit Status")
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}