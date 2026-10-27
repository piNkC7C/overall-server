package cn.iocoder.yudao.module.fms.controller.admin.config.vo.accountset;

import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - FMS books create / edit request.")
@Data
public class FmsAccountSetSaveReqVO {

    @Schema(description = "Books code.", example = "1024")
    private Long id;

    @Schema(description = "Company code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WK001")
    @NotBlank(message = "Company code is required.")
    @Size(max = 64, message = "Company code cannot exceed 64 characters.")
    @DiffLogField(name = "Company code.")
    private String companyCode;

    @Schema(description = "Company Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test Tech LLC")
    @NotBlank(message = "Company Name is required.")
    @Size(max = 255, message = "Company Name cannot exceed 255 characters.")
    @DiffLogField(name = "Company Name")
    private String companyName;

    @Schema(description = "Company bio.", example = "Enterprise digital services")
    @Size(max = 500, message = "Company bio cannot exceed 500 characters.")
    @DiffLogField(name = "Company bio.")
    private String companyProfile;

    @Schema(description = "Industry.", example = "Software and IT services")
    @Size(max = 255, message = "Industry cannot exceed 255 characters.")
    @DiffLogField(name = "Industry")
    private String industry;

    @Schema(description = "Location", example = "Pudong, Shanghai")
    @Size(max = 255, message = "Location cannot exceed 255 characters.")
    @DiffLogField(name = "Location")
    private String location;

    @Schema(description = "Legal representative.", example = "John.")
    @Size(max = 255, message = "Legal representative cannot exceed 255 characters.")
    @DiffLogField(name = "Legal Representative")
    private String legalRepresentative;

    @Schema(description = "Legal-representative ID number.", example = "310101199001011234")
    @Size(max = 255, message = "Legal-representative ID number cannot exceed 255 characters.")
    @DiffLogField(name = "Legal Representative ID Number")
    private String legalRepresentativeIdNumber;

    @Schema(description = "Business license number.", example = "91310000MA1K123456")
    @Size(max = 255, message = "Business license number cannot exceed 255 characters.")
    @DiffLogField(name = "Business License Number")
    private String businessLicenseNumber;

    @Schema(description = "Organization code.", example = "MA1K12345")
    @Size(max = 255, message = "Organization code cannot exceed 255 characters.")
    @DiffLogField(name = "Organization Code")
    private String organizationCode;

    @Schema(description = "Notes.", example = "Standard taxpayer")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    @DiffLogField(name = "Notes.")
    private String remark;

    @Schema(description = "Contact.", example = "Jane.")
    @Size(max = 255, message = "Contact cannot exceed 255 characters.")
    @DiffLogField(name = "Contact.")
    private String contactName;

    @Schema(description = "Office phone.", example = "021-12345678")
    @Size(max = 32, message = "Office phone cannot exceed 32 characters.")
    @DiffLogField(name = "Office Phone")
    private String officeTelephone;

    @Schema(description = "Mobile Number", example = "15601691399")
    @Size(max = 32, message = "Mobile Number cannot exceed 32 characters.")
    @DiffLogField(name = "Mobile Number")
    private String mobile;

    @Schema(description = "Fax number.", example = "021-87654321")
    @Size(max = 32, message = "Fax number cannot exceed 32 characters.")
    @DiffLogField(name = "Fax Number")
    private String faxNumber;

    @Schema(description = "QQ number.", example = "12345678")
    @Size(max = 255, message = "QQ number cannot exceed 255 characters.")
    @DiffLogField(name = "QQ Number")
    private String qqNumber;

    @Schema(description = "Email", example = "finance@example.com")
    @Email(message = "Email format is invalid.")
    @Size(max = 255, message = "Email cannot exceed 255 characters.")
    @DiffLogField(name = "Email")
    private String email;

    @Schema(description = "Other contact.", example = "WeCom：wk-finance.")
    @Size(max = 255, message = "Other contact cannot exceed 255 characters.")
    @DiffLogField(name = "Other Contact")
    private String otherContact;

    @Schema(description = "Full Address", example = "Building 1, Innovation Park")
    @Size(max = 255, message = "Full Address cannot exceed 255 characters.")
    @DiffLogField(name = "Full Address")
    private String address;

}
