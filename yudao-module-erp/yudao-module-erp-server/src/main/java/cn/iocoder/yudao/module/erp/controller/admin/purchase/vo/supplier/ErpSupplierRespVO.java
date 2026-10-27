package cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.supplier;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - ERP supplier response.")
@Data
@ExcelIgnoreUnannotated
public class ErpSupplierRespVO {

    @Schema(description = "Supplier code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "17791")
    @ExcelProperty("Supplier ID")
    private Long id;

    @Schema(description = "Supplier name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @ExcelProperty("Supplier Name")
    private String name;

    @Schema(description = "Contact.", example = "Overall.")
    @ExcelProperty("Contact")
    private String contact;

    @Schema(description = "Mobile Number", example = "15601691300")
    @ExcelProperty("Mobile Number")
    private String mobile;

    @Schema(description = "Phone", example = "18818288888")
    @ExcelProperty("Phone")
    private String telephone;

    @Schema(description = "Email", example = "76853@qq.com")
    @ExcelProperty("Email")
    private String email;

    @Schema(description = "Fax.", example = "20 7123 4567")
    @ExcelProperty("Fax")
    private String fax;

    @Schema(description = "Notes.", example = "Example.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Enable status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Enabled", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @ExcelProperty("Sort")
    private Integer sort;

    @Schema(description = "Tax ID.", example = "91130803MA098BY05W")
    @ExcelProperty("Tax ID")
    private String taxNo;

    @Schema(description = "Tax rate.", example = "10")
    @ExcelProperty("Tax Rate")
    private BigDecimal taxPercent;

    @Schema(description = "Bank", example = "John.")
    @ExcelProperty("Bank Name")
    private String bankName;

    @Schema(description = "Bank Account.", example = "622908212277228617")
    @ExcelProperty("Bank Account No")
    private String bankAccount;

    @Schema(description = "Bank Address.", example = "CIB Pudong Branch")
    @ExcelProperty("Bank Address")
    private String bankAddress;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}