package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.announcement;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS item announcement save request.")
@Data
public class PmsProjectAnnouncementSaveReqVO {

    @Schema(description = "Announcement code.", example = "1024")
    private Long id;

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Item code is required.")
    private Long projectId;

    @Schema(description = "Announcement content.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Announcement content is required.")
    @Size(max = 5000, message = "Announcement content cannot exceed 5000 characters.")
    private String content;

    @Schema(description = "AttachmentAddress list.")
    private List<String> fileUrls;

}
