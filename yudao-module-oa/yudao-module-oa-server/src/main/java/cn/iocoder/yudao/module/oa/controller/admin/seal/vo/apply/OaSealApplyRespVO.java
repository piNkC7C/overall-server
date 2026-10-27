package cn.iocoder.yudao.module.oa.controller.admin.seal.vo.apply;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(description = "Seal request response VO.")
public class OaSealApplyRespVO {

    @Schema(description = "Code.", example = "1024", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "Seal No.", example = "1024", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long sealId;

    @Schema(description = "Seal Reason", example = "Contract seal", requiredMode = Schema.RequiredMode.REQUIRED)
    private String reason;

    @Schema(description = "Seal-use type.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer type;

    @Schema(description = "Seal-use method.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer mode;

    @Schema(description = "File title.", example = "Purchase contract.")
    private String documentTitle;

    @Schema(description = "File type.", example = "Contract.")
    private String documentType;

    @Schema(description = "Copy count.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer documentCount;

    @Schema(description = "Contract amount.", example = "10000.00")
    private BigDecimal contractPrice;

    @Schema(description = "Contract the other party.", example = "Sample Company.")
    private String contractParty;

    @Schema(description = "Planned Seal Time", example = "1789088400000", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64")
    private LocalDateTime expectedUseTime;

    @Schema(description = "Planned Return Time", example = "1789120800000", type = "integer", format = "int64")
    private LocalDateTime expectedReturnTime;

    @Schema(description = "Is not Urgent.", example = "false", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean urgent;

    @Schema(description = "Notes.", example = "Archive after the contract is signed")
    private String remark;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/contract.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "Apply please order no.", example = "SEAL-APPLY-001", requiredMode = Schema.RequiredMode.REQUIRED)
    private String no;

    @Schema(description = "Seal No.", example = "SEAL-001", requiredMode = Schema.RequiredMode.REQUIRED)
    private String sealNo;

    @Schema(description = "Seal Name", example = "Company seal", requiredMode = Schema.RequiredMode.REQUIRED)
    private String sealName;

    @Schema(description = "Seal Type", example = "1")
    private Integer sealType;

    @Schema(description = "Custodian Dept code.", example = "100")
    private Long keeperDeptId;

    @Schema(description = "Custodian Dept", example = "Office")
    private String keeperDeptName;

    @Schema(description = "Apply please person code.", example = "1024", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long userId;

    @Schema(description = "Apply please department code.", example = "1024")
    private Long deptId;

    @Schema(description = "Apply please person.", example = "Overall.")
    private String userName;

    @Schema(description = "Apply please department.", example = "R&D")
    private String deptName;

    @Schema(description = "Custodian code.", example = "1024", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long keeperUserId;

    @Schema(description = "Custodian.", example = "Overall.")
    private String keeperName;

    @Schema(description = "Approval status.", example = "-1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer status;

    @Schema(description = "Seal status.", example = "0", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer useStatus;

    @Schema(description = "Workflow instance code.", example = "b3bb1b18-6001-11ef-9d05-0242ac120002")
    private String processInstanceId;

    @Schema(description = "Actual seal time.", example = "1789088400000", type = "integer", format = "int64")
    private LocalDateTime actualUseTime;

    @Schema(description = "Actual Return Time.", example = "1789120800000", type = "integer", format = "int64")
    private LocalDateTime actualReturnTime;

    @Schema(description = "Create time.", example = "1789088400000", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64")
    private LocalDateTime createTime;
}
