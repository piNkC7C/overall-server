package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.file;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeFileTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "HRM employee document attachments save request VO.")
@Data
public class HrmEmployeeFileSaveReqVO {

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "Attachment type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11")
    @NotNull(message = "Attachment type is required.")
    @InEnum(value = HrmEmployeeFileTypeEnum.class, message = "Attachment type must be {value}.")
    private Integer type;

    @Schema(description = "AttachmentAddressArray.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "[https://example.com/archive.pdf]")
    @NotNull(message = "AttachmentAddressArray is required.")
    @Size(max = 20, message = "Same-type attachments cannot exceed 20.")
    private List<@NotBlank(message = "AttachmentAddress is required.")
            @Size(max = 512, message = "AttachmentAddress length cannot exceed 512 characters.") String> fileUrls;

}
