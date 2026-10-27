package cn.iocoder.yudao.module.oa.controller.admin.contact.vo;

import cn.iocoder.yudao.framework.common.validation.Mobile;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "OA external contact create / update request VO.")
@Data
public class OaContactSaveReqVO {

    @Schema(description = "Contact code.", example = "1024")
    private Long id;

    @Schema(description = "Category code.", example = "1024")
    private Long categoryId;

    @Schema(description = "Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    @NotBlank(message = "Name is required.")
    @Size(max = 50, message = "Name length cannot exceed 50 characters.")
    private String name;

    @Schema(description = "Gender", example = "1")
    private Integer sex;

    @Schema(description = "Mobile Number", requiredMode = Schema.RequiredMode.REQUIRED, example = "13800138000")
    @NotBlank(message = "Mobile Number is required.")
    @Mobile
    @Size(max = 20, message = "Mobile Number length cannot exceed 20 characters.")
    private String mobile;

    @Schema(description = "Email", requiredMode = Schema.RequiredMode.REQUIRED, example = "user@example.com")
    @NotBlank(message = "Email is required.")
    @Email(message = "Email format is invalid.")
    @Size(max = 100, message = "Email length cannot exceed 100 characters.")
    private String email;

    @Schema(description = "Address", example = "100 Main Street, Seattle, WA")
    @Size(max = 255, message = "Address length cannot exceed 255 characters.")
    private String address;

    @Schema(description = "Company Name", example = "Demo Technology Inc.")
    @Size(max = 100, message = "Company Name length cannot exceed 100 characters.")
    private String companyName;

    @Schema(description = "CompanyPhone.", example = "021-12345678")
    @Size(max = 30, message = "CompanyPhone length cannot exceed 30 characters.")
    private String companyPhone;

    @Schema(description = "AvatarAddress.", example = "https://example.com/image.png")
    @Size(max = 512, message = "AvatarAddress length cannot exceed 512 characters.")
    private String avatar;

    @Schema(description = "Notes.", example = "Contact Admin in advance to confirm.")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

}
