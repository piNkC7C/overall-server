package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.file;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "HRM employee document attachments response VO.")
@Data
public class HrmEmployeeFileRespVO {

    @Schema(description = "Attachment code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long employeeId;

    @Schema(description = "Attachment type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11")
    private Integer type;

    @Schema(description = "AttachmentAddress.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String url;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
