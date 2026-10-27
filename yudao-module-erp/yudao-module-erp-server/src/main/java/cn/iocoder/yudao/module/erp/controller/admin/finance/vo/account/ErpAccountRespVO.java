package cn.iocoder.yudao.module.erp.controller.admin.finance.vo.account;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - ERP Settlement Account response.")
@Data
@ExcelIgnoreUnannotated
public class ErpAccountRespVO {

    @Schema(description = "Settlement Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "28684")
    @ExcelProperty("Settlement Account ID")
    private Long id;

    @Schema(description = "Account name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    @ExcelProperty("Account Name")
    private String name;

    @Schema(description = "Account code.", example = "A88")
    @ExcelProperty("Account Code")
    private String no;

    @Schema(description = "Notes.", example = "Sample.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Enable status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Enabled")
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Sort")
    private Integer sort;

    @Schema(description = "Is not default.", example = "1")
    @ExcelProperty("Default")
    private Boolean defaultStatus;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}