package cn.iocoder.yudao.module.mes.controller.admin.md.vendor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - MES 供应商新增/修改 Request VO")
@Data
public class MesMdVendorSaveReqVO {

    @Schema(description = "供应商编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "供应商编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "V00101")
    @NotEmpty(message = "Supplier code is required.")
    @Size(max = 64, message = "Supplier code length cannot exceed 64 characters.")
    private String code;

    @Schema(description = "供应商名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Halide Electronics")
    @NotEmpty(message = "Supplier name is required.")
    @Size(max = 255, message = "Supplier name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "供应商简称", example = "Hailead")
    @Size(max = 255, message = "Supplier short name length cannot exceed 255 characters.")
    private String nickname;

    @Schema(description = "供应商英文名称", example = "HLD Electronics")
    @Size(max = 255, message = "SupplierEnglish Name length cannot exceed 255 characters.")
    private String englishName;

    @Schema(description = "供应商简介", example = "Electronics manufacturing and sales")
    @Size(max = 500, message = "Supplier bio length cannot exceed 500 characters.")
    private String description;

    @Schema(description = "供应商LOGO地址", example = "https://xxx.com/logo.png")
    @Size(max = 255, message = "SupplierLOGOAddress length cannot exceed 255 characters.")
    private String logo;

    @Schema(description = "供应商等级", example = "A")
    @Size(max = 64, message = "Supplier level length cannot exceed 64 characters.")
    private String level;

    @Schema(description = "供应商评分", example = "95")
    private Integer score;

    @Schema(description = "供应商地址", example = "Baoan, Shenzhen")
    @Size(max = 500, message = "SupplierAddress length cannot exceed 500 characters.")
    private String address;

    @Schema(description = "供应商官网地址", example = "https://www.hld-elec.com")
    @Size(max = 255, message = "Supplier website cannot exceed 255 characters.")
    private String website;

    @Schema(description = "供应商邮箱地址", example = "info@hld-elec.com")
    @Size(max = 255, message = "SupplieremailAddress length cannot exceed 255 characters.")
    @Email(message = "SupplieremailAddress format is invalid.")
    private String email;

    @Schema(description = "供应商电话", example = "0755-12345678")
    @Size(max = 64, message = "SupplierPhone length cannot exceed 64 characters.")
    private String telephone;

    @Schema(description = "联系人1", example = "Manager Wang")
    @Size(max = 64, message = "Contact1 length cannot exceed 64 characters.")
    private String contact1Name;

    @Schema(description = "联系人1-电话", example = "13800138001")
    @Size(max = 64, message = "Contact1-Phone length cannot exceed 64 characters.")
    private String contact1Telephone;

    @Schema(description = "联系人1-邮箱", example = "wang@hld-elec.com")
    @Size(max = 255, message = "Contact1-email length cannot exceed 255 characters.")
    @Email(message = "Contact1-email format is invalid.")
    private String contact1Email;

    @Schema(description = "联系人2", example = "Assistant Zhao")
    @Size(max = 64, message = "Contact2 length cannot exceed 64 characters.")
    private String contact2Name;

    @Schema(description = "联系人2-电话", example = "13800138002")
    @Size(max = 64, message = "Contact2-Phone length cannot exceed 64 characters.")
    private String contact2Telephone;

    @Schema(description = "联系人2-邮箱", example = "zhao@hld-elec.com")
    @Size(max = 255, message = "Contact2-email length cannot exceed 255 characters.")
    @Email(message = "Contact2-email format is invalid.")
    private String contact2Email;

    @Schema(description = "统一社会信用代码", example = "91440300MA5EXAMPLE")
    @Size(max = 64, message = "Unified social credit code cannot exceed 64 characters.")
    private String creditCode;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

}
