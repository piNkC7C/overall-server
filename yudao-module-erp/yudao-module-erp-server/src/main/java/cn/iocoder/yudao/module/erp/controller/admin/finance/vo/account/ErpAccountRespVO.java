package cn.iocoder.yudao.module.erp.controller.admin.finance.vo.account;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - ERP 结算账户 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ErpAccountRespVO {

    @Schema(description = "结算账户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "28684")
    @ExcelProperty("Settlement Account ID")
    private Long id;

    @Schema(description = "账户名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    @ExcelProperty("Account Name")
    private String name;

    @Schema(description = "账户编码", example = "A88")
    @ExcelProperty("Account Code")
    private String no;

    @Schema(description = "备注", example = "Sample.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "开启状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Enabled")
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Sort")
    private Integer sort;

    @Schema(description = "是否默认", example = "1")
    @ExcelProperty("Default")
    private Boolean defaultStatus;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}