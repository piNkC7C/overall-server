package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - PMS work item nameupdate request.")
@Data
public class PmsWorkItemNameUpdateReqVO {

    @Schema(description = "Work item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Work item code is required.")
    private Long id;

    @Schema(description = "Work item title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Finish the sign-in page")
    @NotBlank(message = "Work item title is required.")
    @Size(max = 100, message = "Work item title cannot exceed 100 characters.")
    private String name;

}
