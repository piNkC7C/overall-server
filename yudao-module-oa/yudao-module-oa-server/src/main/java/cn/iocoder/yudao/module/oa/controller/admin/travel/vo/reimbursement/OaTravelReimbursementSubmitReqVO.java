package cn.iocoder.yudao.module.oa.controller.admin.travel.vo.reimbursement;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "Travel expense submit request VO.")
@Data
public class OaTravelReimbursementSubmitReqVO {

    @Schema(description = "Document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Document code is required.")
    private Long id;

    @Schema(description = "Approvers selected by the starter.")
    private Map<String, List<Long>> startUserSelectAssignees;

}
