package cn.iocoder.yudao.module.wms.controller.admin.md.merchant.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.wms.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - WMS 往来企业 Response VO")
@Data
@ExcelIgnoreUnannotated
public class WmsMerchantRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "往来企业编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "MER001")
    @ExcelProperty("Counterparty ID")
    private String code;

    @Schema(description = "往来企业名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Huawei")
    @ExcelProperty("Counterparty Name")
    private String name;

    @Schema(description = "往来企业类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty(value = "Counterparty Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MERCHANT_TYPE)
    private Integer type;

    @Schema(description = "级别", example = "A")
    @ExcelProperty("Level")
    private String level;

    @Schema(description = "开户行", example = "China Merchants Bank")
    private String bankName;

    @Schema(description = "银行账户", example = "6225888888888888")
    private String bankAccount;

    @Schema(description = "地址", example = "Nanshan, Shenzhen")
    private String address;

    @Schema(description = "手机号", example = "15601691300")
    private String mobile;

    @Schema(description = "座机号", example = "0755-88888888")
    private String telephone;

    @Schema(description = "联系人", example = "Alex.")
    @ExcelProperty("Contact")
    private String contact;

    @Schema(description = "Email", example = "wms@example.com")
    private String email;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
