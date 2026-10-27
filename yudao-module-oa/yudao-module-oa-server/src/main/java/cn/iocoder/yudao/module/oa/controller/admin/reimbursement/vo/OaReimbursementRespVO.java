package cn.iocoder.yudao.module.oa.controller.admin.reimbursement.vo;

import cn.iocoder.yudao.module.oa.dal.dataobject.reimbursement.OaReimbursementDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Expense report response VO.")
@Data
public class OaReimbursementRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Title.", example = "Customer-project travel reimbursement")
    private String title;

    @Schema(description = "Urgency", example = "1")
    private Integer urgency;

    @Schema(description = "Apply please reason.", example = "Reimburse travel during customer acceptance")
    private String reason;

    @Schema(description = "Reference user ID.", example = "1024")
    private Long witnessUserId;

    @Schema(description = "Related customer.", example = "Demo Technology Inc.")
    private String customerName;

    @Schema(description = "Reimbursement method.", example = "1")
    private Integer paymentMethod;

    @Schema(description = "Receipt count.", example = "1")
    private Integer invoiceCount;

    @Schema(description = "Reimbursement Total", example = "100.00")
    private BigDecimal totalPrice;

    @Schema(description = "Approval status.", example = "-1")
    private Integer status;

    @Schema(description = "Workflow instance code.", example = "1024")
    private String processInstanceId;

    @Schema(description = "Reimbursement lines.")
    private List<OaReimbursementDO.Item> items;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "Apply please person code.", example = "1024")
    private String creator;

    @Schema(description = "Apply please person Nickname.", example = "John.")
    private String creatorName;

    @Schema(description = "Apply please time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;
}
