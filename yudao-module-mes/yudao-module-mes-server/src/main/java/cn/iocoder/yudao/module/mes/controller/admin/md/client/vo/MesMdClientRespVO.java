package cn.iocoder.yudao.module.mes.controller.admin.md.client.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES customer response.")
@Data
@ExcelIgnoreUnannotated
public class MesMdClientRespVO {

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Customer ID")
    private Long id;

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "C00184")
    @ExcelProperty("Customer Code")
    private String code;

    @Schema(description = "Customer name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "BYD")
    @ExcelProperty("Customer Name")
    private String name;

    @Schema(description = "Customer short name.", example = "BYD")
    @ExcelProperty("Customer Short Name")
    private String nickname;

    @Schema(description = "CustomerEnglish Name.", example = "BYD")
    @ExcelProperty("Customer English Name")
    private String englishName;

    @Schema(description = "Customer bio.", example = "The BYD brand started in Shenzhen")
    @ExcelProperty("Customer Summary")
    private String description;

    @Schema(description = "CustomerLOGOAddress.", example = "https://xxx.com/logo.png")
    private String logo;

    @Schema(description = "Customer type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "CustomerType", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_CLIENT_TYPE)
    private Integer type;

    @Schema(description = "CustomerAddress.", example = "Nanshan, Shenzhen")
    @ExcelProperty("Customer Address")
    private String address;

    @Schema(description = "Customer website.", example = "https://www.bydglobal.com")
    @ExcelProperty("Customer Website")
    private String website;

    @Schema(description = "CustomeremailAddress.", example = "salse@bydglobal.com")
    @ExcelProperty("Customer Email")
    private String email;

    @Schema(description = "CustomerPhone.", example = "123432222")
    @ExcelProperty("Customer Phone")
    private String telephone;

    @Schema(description = "Contact1.", example = "John.")
    @ExcelProperty("Contact 1")
    private String contact1Name;

    @Schema(description = "Contact1-Phone.", example = "122212312")
    @ExcelProperty("Contact 1 Phone")
    private String contact1Telephone;

    @Schema(description = "Contact1-email.", example = "s1@bydglobal.com")
    @ExcelProperty("Contact 1 Email")
    private String contact1Email;

    @Schema(description = "Contact2.", example = "Jane.")
    @ExcelProperty("Contact 2")
    private String contact2Name;

    @Schema(description = "Contact2-Phone.", example = "1132323232")
    @ExcelProperty("Contact 2 Phone")
    private String contact2Telephone;

    @Schema(description = "Contact2-email.", example = "s2@bydglobal.com")
    @ExcelProperty("Contact 2 Email")
    private String contact2Email;

    @Schema(description = "Unified social credit code.", example = "11212121")
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
