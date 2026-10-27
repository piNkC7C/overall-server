package cn.iocoder.yudao.module.oa.controller.admin.overtime.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "Overtime request submit request VO.")
@Data
public class OaOvertimeApplySubmitReqVO {

    @Schema(description = "Apply please code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Apply please code is required.")
    private Long id;

    @Schema(description = "Approvers selected by the starter.")
    private Map<String, List<Long>> startUserSelectAssignees;

}
