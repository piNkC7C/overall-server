package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.personalnote;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - HRM employee person memo create request.")
@Data
public class HrmEmployeePersonalNoteCreateReqVO {

    @Schema(description = "Memo content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Follow confirmation documents")
    @NotBlank(message = "Memo content is required.")
    @Size(max = 1024, message = "Memo content cannot exceed 1024 characters.")
    private String content;

    @Schema(description = "Reminder time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Reminder time cannot be empty.")
    private LocalDateTime reminderTime;

}
