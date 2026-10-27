package cn.iocoder.yudao.module.wms.controller.admin.md.merchant.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.wms.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - WMS business partner response.")
@Data
@ExcelIgnoreUnannotated
public class WmsMerchantRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Business partner code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "MER001")
    @ExcelProperty("Counterparty ID")
    private String code;

    @Schema(description = "Business partner name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Huawei")
    @ExcelProperty("Counterparty Name")
    private String name;

    @Schema(description = "Business partner type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty(value = "Counterparty Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MERCHANT_TYPE)
    private Integer type;

    @Schema(description = "Level.", example = "A")
    @ExcelProperty("Level")
    private String level;

    @Schema(description = "Bank", example = "China Merchants Bank")
    private String bankName;

    @Schema(description = "Bank account.", example = "6225888888888888")
    private String bankAccount;

    @Schema(description = "Address", example = "Nanshan, Shenzhen")
    private String address;

    @Schema(description = "Phone number.", example = "15601691300")
    private String mobile;

    @Schema(description = "Landline.", example = "0755-88888888")
    private String telephone;

    @Schema(description = "Contact.", example = "Alex.")
    @ExcelProperty("Contact")
    private String contact;

    @Schema(description = "Email", example = "wms@example.com")
    private String email;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
