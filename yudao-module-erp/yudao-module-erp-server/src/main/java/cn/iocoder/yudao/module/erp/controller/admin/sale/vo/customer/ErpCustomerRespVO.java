package cn.iocoder.yudao.module.erp.controller.admin.sale.vo.customer;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - ERP 客户 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ErpCustomerRespVO {

    @Schema(description = "客户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "27520")
    @ExcelProperty("Customer ID")
    private Long id;

    @Schema(description = "客户名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    @ExcelProperty("Customer Name")
    private String name;

    @Schema(description = "联系人", example = "Alex")
    @ExcelProperty("Contact")
    private String contact;

    @Schema(description = "手机号码", example = "15601691300")
    @ExcelProperty("Mobile Number")
    private String mobile;

    @Schema(description = "联系电话", example = "15601691300")
    @ExcelProperty("Phone")
    private String telephone;

    @Schema(description = "电子邮箱", example = "7685323@qq.com")
    @ExcelProperty("Email")
    private String email;

    @Schema(description = "传真", example = "20 7123 4567")
    @ExcelProperty("Fax")
    private String fax;

    @Schema(description = "备注", example = "Example.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "开启状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Enabled", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer status;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @ExcelProperty("Sort")
    private Integer sort;

    @Schema(description = "纳税人识别号", example = "91130803MA098BY05W")
    @ExcelProperty("Tax ID")
    private String taxNo;

    @Schema(description = "税率", example = "10")
    @ExcelProperty("Tax Rate")
    private BigDecimal taxPercent;

    @Schema(description = "开户行", example = "Overall.")
    @ExcelProperty("Bank Name")
    private String bankName;

    @Schema(description = "开户账号", example = "622908212277228617")
    @ExcelProperty("Bank Account No")
    private String bankAccount;

    @Schema(description = "开户地址", example = "CIB Pudong Branch")
    @ExcelProperty("Bank Address")
    private String bankAddress;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}