package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.personalnote;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - HRM 员工个人备忘创建 Request VO")
@Data
public class HrmEmployeePersonalNoteCreateReqVO {

    @Schema(description = "备忘内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "Follow confirmation documents")
    @NotBlank(message = "Memo content is required.")
    @Size(max = 1024, message = "Memo content cannot exceed 1024 characters.")
    private String content;

    @Schema(description = "提醒时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Reminder time cannot be empty.")
    private LocalDateTime reminderTime;

}
