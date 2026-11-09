package cn.iocoder.yudao.module.oa.controller.admin.contact.vo;

import cn.iocoder.yudao.framework.common.validation.Mobile;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - OA 外部联系人新增/修改 Request VO")
@Data
public class OaContactSaveReqVO {

    @Schema(description = "联系人编号", example = "1024")
    private Long id;

    @Schema(description = "分类编号", example = "1024")
    private Long categoryId;

    @Schema(description = "姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    @NotBlank(message = "Name is required.")
    @Size(max = 50, message = "Name length cannot exceed 50 characters.")
    private String name;

    @Schema(description = "性别", example = "1")
    private Integer sex;

    @Schema(description = "手机号码", requiredMode = Schema.RequiredMode.REQUIRED, example = "13800138000")
    @NotBlank(message = "Mobile Number is required.")
    @Mobile
    @Size(max = 20, message = "Mobile Number length cannot exceed 20 characters.")
    private String mobile;

    @Schema(description = "邮箱", requiredMode = Schema.RequiredMode.REQUIRED, example = "user@example.com")
    @NotBlank(message = "Email is required.")
    @Email(message = "Email format is invalid.")
    @Size(max = 100, message = "Email length cannot exceed 100 characters.")
    private String email;

    @Schema(description = "地址", example = "100 Main Street, Seattle, WA")
    @Size(max = 255, message = "Address length cannot exceed 255 characters.")
    private String address;

    @Schema(description = "公司名称", example = "Demo Technology Inc.")
    @Size(max = 100, message = "Company Name length cannot exceed 100 characters.")
    private String companyName;

    @Schema(description = "公司电话", example = "021-12345678")
    @Size(max = 30, message = "CompanyPhone length cannot exceed 30 characters.")
    private String companyPhone;

    @Schema(description = "头像地址", example = "https://example.com/image.png")
    @Size(max = 512, message = "AvatarAddress length cannot exceed 512 characters.")
    private String avatar;

    @Schema(description = "备注", example = "Contact Admin in advance to confirm.")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

}
