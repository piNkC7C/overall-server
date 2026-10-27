package cn.iocoder.yudao.module.oa.controller.admin.officialdoc.vo.send;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Outgoing official document response VO.")
@Data
public class OaOfficialDocSendRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Letterhead templateID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long templateId;

    @Schema(description = "Document Title", requiredMode = Schema.RequiredMode.REQUIRED, example = "Notice: Office supply inventory")
    private String title;

    @Schema(description = "Character no.", example = "OA")
    private String noPrefix;

    @Schema(description = "Year.", example = "2026")
    private Integer year;

    @Schema(description = "Document sequence.", example = "1")
    private Integer sequence;

    @Schema(description = "Classification.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer secrecyLevel;

    @Schema(description = "Urgency", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer urgencyLevel;

    @Schema(description = "Disclosure Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer disclosureType;

    @Schema(description = "Issue Date", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime issueTime;

    @Schema(description = "Issuing Dept code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long sendDeptId;

    @Schema(description = "Primary Dept code list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 2]")
    private List<Long> mainDeptIds;

    @Schema(description = "Cc department IDslist.", example = "[1, 2]")
    private List<Long> copyDeptIds;

    @Schema(description = "Document body.", example = "Please finish the office-supply count and submit results by Friday.")
    private String content;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "Official DocumentAddress.", example = "https://example.com/file.pdf")
    private String formalFileUrl;

    @Schema(description = "Notes.", example = "Please handle this as requested and report back")
    private String remark;

    @Schema(description = "Document code.", example = "CC202609140001")
    private String no;

    @Schema(description = "Document no.", example = "OA-2026-1")
    private String documentNo;

    @Schema(description = "Issuer code.", example = "1024")
    private Long signerUserId;

    @Schema(description = "Issuer", example = "John.")
    private String signerName;

    @Schema(description = "Issuing Dept", example = "Administration.")
    private String sendDeptName;

    @Schema(description = "Primary Dept", example = "[\"Administration\"]")
    private List<String> mainDeptNames;

    @Schema(description = "Cc Departments.", example = "[\"Finance\"]")
    private List<String> copyDeptNames;

    @Schema(description = "Approval status.", example = "-1")
    private Integer status;

    @Schema(description = "Workflow instance code.", example = "1024")
    private String processInstanceId;

    @Schema(description = "Creator code.", example = "1024")
    private String creator;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

}
