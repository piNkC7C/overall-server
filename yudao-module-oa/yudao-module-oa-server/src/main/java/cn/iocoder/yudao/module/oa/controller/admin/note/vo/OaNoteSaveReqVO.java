package cn.iocoder.yudao.module.oa.controller.admin.note.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.note.OaNoteTypeEnum;
import cn.iocoder.yudao.module.oa.enums.schedule.OaPriorityEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - OA Note create / edit request.")
@Data
public class OaNoteSaveReqVO {

    @Schema(description = "Note code.", example = "1024")
    private Long id;

    @Schema(description = "Directory code.", example = "1024")
    private Long categoryId;

    @Schema(description = "Note type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Note type is required.")
    @InEnum(value = OaNoteTypeEnum.class, message = "Note type must be {value}.")
    private Integer type;

    @Schema(description = "Priority", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Priority is required.")
    @InEnum(value = OaPriorityEnum.class, message = "Priority must be {value}.")
    @Max(value = 2, message = "Note priority must be Normal or Important.")
    private Integer priority;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Project meeting minutes")
    @NotBlank(message = "Title is required.")
    @Size(max = 255, message = "Title length cannot exceed 255 characters.")
    private String title;

    @Schema(description = "Content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Record this week's meeting decisions and action items.")
    @NotBlank(message = "Note content is required.")
    private String content;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    private List<@NotBlank(message = "AttachmentAddress is required.") @Size(max = 512, message = "AttachmentAddress length cannot exceed 512 characters.") String> fileUrls;

}
