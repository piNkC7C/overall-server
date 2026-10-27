package cn.iocoder.yudao.module.fms.controller.admin.config.vo.accountset;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - FMS books response.")
@Data
public class FmsAccountSetRespVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Company code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WK001")
    private String companyCode;

    @Schema(description = "Company Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test Tech LLC")
    private String companyName;

    @Schema(description = "Company bio.", example = "Enterprise digital services")
    private String companyProfile;

    @Schema(description = "Industry.", example = "Software and IT services")
    private String industry;

    @Schema(description = "Location", example = "Pudong, Shanghai")
    private String location;

    @Schema(description = "Legal representative.", example = "John.")
    private String legalRepresentative;

    @Schema(description = "Legal-representative ID number.", example = "310101199001011234")
    private String legalRepresentativeIdNumber;

    @Schema(description = "Business license number.", example = "91310000MA1K123456")
    private String businessLicenseNumber;

    @Schema(description = "Organization code.", example = "MA1K12345")
    private String organizationCode;

    @Schema(description = "Notes.", example = "Standard taxpayer")
    private String remark;

    @Schema(description = "Contact.", example = "Jane.")
    private String contactName;

    @Schema(description = "Office phone.", example = "021-12345678")
    private String officeTelephone;

    @Schema(description = "Mobile Number", example = "15601691399")
    private String mobile;

    @Schema(description = "Fax number.", example = "021-87654321")
    private String faxNumber;

    @Schema(description = "QQ number.", example = "12345678")
    private String qqNumber;

    @Schema(description = "Email", example = "finance@example.com")
    private String email;

    @Schema(description = "Other contact.", example = "WeCom：wk-finance.")
    private String otherContact;

    @Schema(description = "Full Address", example = "Building 1, Innovation Park")
    private String address;

    @Schema(description = "Currency ID.", example = "1024")
    private Long currencyId;

    @Schema(description = "Enabled period.")
    private LocalDateTime startTime;

    @Schema(description = "Accounting system.", example = "1")
    private Integer standard;

    @Schema(description = "Initialized.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean initialized;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    // ==================== 来自 FmsAccountUserDO ====================

    @Schema(description = "Is not default books.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean defaultStatus;

    @Schema(description = "Is not books creator.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean founder;

    @Schema(description = "Current user member permission level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer level;

}
