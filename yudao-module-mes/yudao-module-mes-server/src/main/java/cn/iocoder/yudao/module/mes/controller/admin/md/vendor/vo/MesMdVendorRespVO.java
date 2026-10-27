package cn.iocoder.yudao.module.mes.controller.admin.md.vendor.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES supplier response.")
@Data
@ExcelIgnoreUnannotated
public class MesMdVendorRespVO {

    @Schema(description = "Supplier code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Supplier ID")
    private Long id;

    @Schema(description = "Supplier code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "V00101")
    @ExcelProperty("Supplier Code")
    private String code;

    @Schema(description = "Supplier name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Halide Electronics")
    @ExcelProperty("Supplier Name")
    private String name;

    @Schema(description = "Supplier short name.", example = "Hailead")
    @ExcelProperty("Supplier Short Name")
    private String nickname;

    @Schema(description = "SupplierEnglish Name.", example = "HLD Electronics")
    @ExcelProperty("Supplier English Name")
    private String englishName;

    @Schema(description = "Supplier bio.", example = "Electronics manufacturing and sales")
    @ExcelProperty("Supplier Summary")
    private String description;

    @Schema(description = "SupplierLOGOAddress.", example = "https://xxx.com/logo.png")
    private String logo;

    @Schema(description = "Supplier level.", example = "A")
    @ExcelProperty(value = "Supplier Grade", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_VENDOR_LEVEL)
    private String level;

    @Schema(description = "SupplierScore.", example = "95")
    @ExcelProperty("Supplier Rating")
    private Integer score;

    @Schema(description = "SupplierAddress.", example = "Baoan, Shenzhen")
    @ExcelProperty("Supplier Address")
    private String address;

    @Schema(description = "Supplier website.", example = "https://www.hld-elec.com")
    @ExcelProperty("Supplier Website")
    private String website;

    @Schema(description = "SupplieremailAddress.", example = "info@hld-elec.com")
    @ExcelProperty("Supplier Email")
    private String email;

    @Schema(description = "SupplierPhone.", example = "0755-12345678")
    @ExcelProperty("Supplier Phone")
    private String telephone;

    @Schema(description = "Contact1.", example = "Manager Wang")
    @ExcelProperty("Contact 1")
    private String contact1Name;

    @Schema(description = "Contact1-Phone.", example = "13800138001")
    @ExcelProperty("Contact 1 Phone")
    private String contact1Telephone;

    @Schema(description = "Contact1-email.", example = "wang@hld-elec.com")
    @ExcelProperty("Contact 1 Email")
    private String contact1Email;

    @Schema(description = "Contact2.", example = "Assistant Zhao")
    @ExcelProperty("Contact 2")
    private String contact2Name;

    @Schema(description = "Contact2-Phone.", example = "13800138002")
    @ExcelProperty("Contact 2 Phone")
    private String contact2Telephone;

    @Schema(description = "Contact2-email.", example = "zhao@hld-elec.com")
    @ExcelProperty("Contact 2 Email")
    private String contact2Email;

    @Schema(description = "Unified social credit code.", example = "91440300MA5EXAMPLE")
    @ExcelProperty("USCC")
    private String creditCode;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(cn.iocoder.yudao.module.system.enums.DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
