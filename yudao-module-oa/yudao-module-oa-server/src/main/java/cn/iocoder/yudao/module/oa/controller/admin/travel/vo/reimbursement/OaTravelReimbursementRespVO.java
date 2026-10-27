package cn.iocoder.yudao.module.oa.controller.admin.travel.vo.reimbursement;

import cn.iocoder.yudao.module.oa.dal.dataobject.travel.OaTravelReimbursementDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Travel expense response VO.")
@Data
public class OaTravelReimbursementRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "CLBX202609140001")
    private String no;

    @Schema(description = "Travel Reason", example = "Travel to Beijing for customer acceptance")
    private String reason;

    @Schema(description = "Start Date.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime startTime;

    @Schema(description = "End Date.", type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime endTime;

    @Schema(description = "Related Travel RequestID.", example = "1024")
    private Long travelApplyId;

    @Schema(description = "Notes.", example = "Contact Admin in advance to confirm.")
    private String remark;

    @Schema(description = "Travel Days", example = "1")
    private Integer days;

    @Schema(description = "Approval status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "-1")
    private Integer status;

    @Schema(description = "Payment status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean payStatus;

    @Schema(description = "Reimbursement Total", example = "100.00")
    private BigDecimal totalPrice;

    @Schema(description = "Related travel request no.", example = "CC202609140001")
    private String travelApplyNo;

    @Schema(description = "Workflow instance code.", example = "1024")
    private String processInstanceId;

    @Schema(description = "Apply please person code.", example = "1024")
    private String creator;

    @Schema(description = "Apply please person Name.", example = "John.")
    private String creatorName;

    @Schema(description = "Apply please department code.", example = "1024")
    private Long deptId;

    @Schema(description = "Apply please department.", example = "Administration.")
    private String deptName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

    @Schema(description = "Detail.")
    private List<OaTravelReimbursementDO.Item> items;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    private List<String> fileUrls;


}
