package cn.iocoder.yudao.module.mes.controller.admin.md.vendor.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 供应商 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesMdVendorRespVO {

    @Schema(description = "供应商编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Supplier ID")
    private Long id;

    @Schema(description = "供应商编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "V00101")
    @ExcelProperty("Supplier Code")
    private String code;

    @Schema(description = "供应商名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Halide Electronics")
    @ExcelProperty("Supplier Name")
    private String name;

    @Schema(description = "供应商简称", example = "Hailead")
    @ExcelProperty("Supplier Short Name")
    private String nickname;

    @Schema(description = "供应商英文名称", example = "HLD Electronics")
    @ExcelProperty("Supplier English Name")
    private String englishName;

    @Schema(description = "供应商简介", example = "Electronics manufacturing and sales")
    @ExcelProperty("Supplier Summary")
    private String description;

    @Schema(description = "供应商LOGO地址", example = "https://xxx.com/logo.png")
    private String logo;

    @Schema(description = "供应商等级", example = "A")
    @ExcelProperty(value = "Supplier Grade", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_VENDOR_LEVEL)
    private String level;

    @Schema(description = "供应商评分", example = "95")
    @ExcelProperty("Supplier Rating")
    private Integer score;

    @Schema(description = "供应商地址", example = "Baoan, Shenzhen")
    @ExcelProperty("Supplier Address")
    private String address;

    @Schema(description = "供应商官网地址", example = "https://www.hld-elec.com")
    @ExcelProperty("Supplier Website")
    private String website;

    @Schema(description = "供应商邮箱地址", example = "info@hld-elec.com")
    @ExcelProperty("Supplier Email")
    private String email;

    @Schema(description = "供应商电话", example = "0755-12345678")
    @ExcelProperty("Supplier Phone")
    private String telephone;

    @Schema(description = "联系人1", example = "Manager Wang")
    @ExcelProperty("Contact 1")
    private String contact1Name;

    @Schema(description = "联系人1-电话", example = "13800138001")
    @ExcelProperty("Contact 1 Phone")
    private String contact1Telephone;

    @Schema(description = "联系人1-邮箱", example = "wang@hld-elec.com")
    @ExcelProperty("Contact 1 Email")
    private String contact1Email;

    @Schema(description = "联系人2", example = "Assistant Zhao")
    @ExcelProperty("Contact 2")
    private String contact2Name;

    @Schema(description = "联系人2-电话", example = "13800138002")
    @ExcelProperty("Contact 2 Phone")
    private String contact2Telephone;

    @Schema(description = "联系人2-邮箱", example = "zhao@hld-elec.com")
    @ExcelProperty("Contact 2 Email")
    private String contact2Email;

    @Schema(description = "统一社会信用代码", example = "91440300MA5EXAMPLE")
    @ExcelProperty("USCC")
    private String creditCode;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(cn.iocoder.yudao.module.system.enums.DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
