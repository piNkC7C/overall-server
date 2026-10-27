package cn.iocoder.yudao.module.oa.controller.admin.contact.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "OA external contact response VO.")
@Data
public class OaContactRespVO {

    @Schema(description = "Contact code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Creator user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long ownerUserId;

    @Schema(description = "Creator nickname.", example = "Overall.")
    private String ownerUserName;

    @Schema(description = "Category code.", example = "1024")
    private Long categoryId;

    @Schema(description = "Category name.", example = "Customer.")
    private String categoryName;

    @Schema(description = "Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    private String name;

    @Schema(description = "Name pinyin.", example = "zhangsan")
    private String pinyin;

    @Schema(description = "Gender", example = "1")
    private Integer sex;

    @Schema(description = "Mobile Number", example = "13800138000")
    private String mobile;

    @Schema(description = "Email", example = "yudao@example.com")
    private String email;

    @Schema(description = "Address", example = "100 Main Street, Seattle, WA")
    private String address;

    @Schema(description = "Company Name", example = "Demo Technology Inc.")
    private String companyName;

    @Schema(description = "CompanyPhone.", example = "021-12345678")
    private String companyPhone;

    @Schema(description = "AvatarAddress.", example = "https://example.com/image.png")
    private String avatar;

    @Schema(description = "Notes.", example = "Contact Admin in advance to confirm.")
    private String remark;

    @Schema(description = "Share record list.")
    private List<Share> shares;

    @Schema(description = "Share relation for this row. Only on the shares-I-created list.")
    private Share share;

    @Schema(description = "Sharer nickname for the current user.", example = "Overall.")
    private String sharerName;

    @Schema(description = "Current Recipient process status.", example = "false")
    private Boolean handleStatus;

    @Schema(description = "Current Recipient category code.", example = "1024")
    private Long sharedCategoryId;

    @Schema(description = "Current Recipient category name.", example = "Customercontact.")
    private String sharedCategoryName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

    @Schema(description = "OA contact share response VO.")
    @Data
    public static class Share {

        @Schema(description = "Share record ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long id;

        @Schema(description = "Share Recipients user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long userId;

        @Schema(description = "Actual sharer nickname.", example = "John.")
        private String creatorName;

        @Schema(description = "Share Recipients nickname.", example = "Overall.")
        private String userName;

        @Schema(description = "Share Recipients user avatar.", example = "https://example.com/avatar.png")
        private String userAvatar;

        @Schema(description = "Category code.", example = "1024")
        private Long categoryId;

        @Schema(description = "Recipient category name.", example = "Customer.")
        private String categoryName;

        @Schema(description = "Process status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
        private Boolean handleStatus;

        @Schema(description = "Shared.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1789347600000")
        private LocalDateTime createTime;

    }

}
