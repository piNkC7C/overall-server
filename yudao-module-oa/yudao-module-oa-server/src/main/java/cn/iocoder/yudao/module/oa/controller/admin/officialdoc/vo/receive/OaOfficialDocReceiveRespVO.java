package cn.iocoder.yudao.module.oa.controller.admin.officialdoc.vo.receive;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Incoming official document response VO.")
@Data
public class OaOfficialDocReceiveRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Source dispatch ID.", example = "1024")
    private Long sendId;

    @Schema(description = "Issuing Dept", example = "Administration.")
    private String sendDeptName;

    @Schema(description = "Issue Date", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime issueTime;

    @Schema(description = "Issuer", example = "John.")
    private String signerName;

    @Schema(description = "Disclosure Type", example = "0")
    private Integer disclosureType;

    @Schema(description = "Incoming Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer receiveType;

    @Schema(description = "Received time.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime receiveTime;

    @Schema(description = "Incoming Dept code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long receiveDeptId;

    @Schema(description = "Owner user ID.", example = "1024")
    private Long handlerUserId;

    @Schema(description = "Leader comment.", example = "Please have Admin lead this")
    private String instruction;

    @Schema(description = "Handle result.", example = "Count completed and archived")
    private String result;

    @Schema(description = "Due Date.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime deadlineTime;

    @Schema(description = "ContentSummary.", example = "Finished this week's office-supply count")
    private String summary;

    @Schema(description = "Notes.", example = "Contact Admin in advance to confirm.")
    private String remark;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "Document code.", example = "CC202609140001")
    private String no;

    @Schema(description = "Document Title", example = "Notice: Office supply inventory")
    private String title;

    @Schema(description = "Incoming Doc No.", example = "OA-2026-1")
    private String documentNo;

    @Schema(description = "Classification.", example = "0")
    private Integer secrecyLevel;

    @Schema(description = "Urgency", example = "0")
    private Integer urgencyLevel;

    @Schema(description = "Official DocumentAddress.", example = "https://example.com/file.pdf")
    private String formalFileUrl;

    @Schema(description = "Incoming Dept", example = "Administration.")
    private String receiveDeptName;

    @Schema(description = "Owner", example = "John.")
    private String handlerName;

    @Schema(description = "Approval status.", example = "-1")
    private Integer status;

    @Schema(description = "Handle status.", example = "0")
    private Integer handleStatus;

    @Schema(description = "Workflow instance code.", example = "1024")
    private String processInstanceId;

    @Schema(description = "Creator code.", example = "1024")
    private String creator;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

}
