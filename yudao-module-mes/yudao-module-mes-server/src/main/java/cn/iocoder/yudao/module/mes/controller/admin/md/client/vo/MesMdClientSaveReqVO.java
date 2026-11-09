package cn.iocoder.yudao.module.mes.controller.admin.md.client.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - MES 客户新增/修改 Request VO")
@Data
public class MesMdClientSaveReqVO {

    @Schema(description = "客户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "客户编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "C00184")
    @NotEmpty(message = "Customer code is required.")
    @Size(max = 64, message = "Customer code length cannot exceed 64 characters.")
    private String code;

    @Schema(description = "客户名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "BYD")
    @NotEmpty(message = "Customer name is required.")
    @Size(max = 255, message = "Customer name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "客户简称", example = "BYD")
    @Size(max = 255, message = "Customer short name length cannot exceed 255 characters.")
    private String nickname;

    @Schema(description = "客户英文名称", example = "BYD")
    @Size(max = 255, message = "CustomerEnglish Name length cannot exceed 255 characters.")
    private String englishName;

    @Schema(description = "客户简介", example = "The BYD brand started in Shenzhen")
    @Size(max = 500, message = "Customer bio length cannot exceed 500 characters.")
    private String description;

    @Schema(description = "客户LOGO地址", example = "https://xxx.com/logo.png")
    @Size(max = 255, message = "CustomerLOGOAddress length cannot exceed 255 characters.")
    private String logo;

    @Schema(description = "客户类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Customer type is required.")
    private Integer type;

    @Schema(description = "客户地址", example = "Nanshan, Shenzhen")
    @Size(max = 500, message = "CustomerAddress length cannot exceed 500 characters.")
    private String address;

    @Schema(description = "客户官网地址", example = "https://www.bydglobal.com")
    @Size(max = 255, message = "Customer website cannot exceed 255 characters.")
    private String website;

    @Schema(description = "客户邮箱地址", example = "salse@bydglobal.com")
    @Size(max = 255, message = "CustomeremailAddress length cannot exceed 255 characters.")
    @Email(message = "CustomeremailAddress format is invalid.")
    private String email;

    @Schema(description = "客户电话", example = "123432222")
    @Size(max = 64, message = "CustomerPhone length cannot exceed 64 characters.")
    private String telephone;

    @Schema(description = "联系人1", example = "John.")
    @Size(max = 64, message = "Contact1 length cannot exceed 64 characters.")
    private String contact1Name;

    @Schema(description = "联系人1-电话", example = "122212312")
    @Size(max = 64, message = "Contact1-Phone length cannot exceed 64 characters.")
    private String contact1Telephone;

    @Schema(description = "联系人1-邮箱", example = "s1@bydglobal.com")
    @Size(max = 255, message = "Contact1-email length cannot exceed 255 characters.")
    @Email(message = "Contact1-email format is invalid.")
    private String contact1Email;

    @Schema(description = "联系人2", example = "Jane.")
    @Size(max = 64, message = "Contact2 length cannot exceed 64 characters.")
    private String contact2Name;

    @Schema(description = "联系人2-电话", example = "1132323232")
    @Size(max = 64, message = "Contact2-Phone length cannot exceed 64 characters.")
    private String contact2Telephone;

    @Schema(description = "联系人2-邮箱", example = "s2@bydglobal.com")
    @Size(max = 255, message = "Contact2-email length cannot exceed 255 characters.")
    @Email(message = "Contact2-email format is invalid.")
    private String contact2Email;

    @Schema(description = "统一社会信用代码", example = "11212121")
    @Size(max = 64, message = "Unified social credit code cannot exceed 64 characters.")
    private String creditCode;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

}
