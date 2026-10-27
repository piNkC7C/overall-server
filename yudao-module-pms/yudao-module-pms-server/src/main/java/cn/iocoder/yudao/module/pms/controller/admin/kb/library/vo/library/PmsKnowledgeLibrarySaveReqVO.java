package cn.iocoder.yudao.module.pms.controller.admin.kb.library.vo.library;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS knowledge base create / edit request.")
@Data
public class PmsKnowledgeLibrarySaveReqVO {

    @Schema(description = "Knowledge base code.", example = "1024")
    private Long id;

    @Schema(description = "Knowledge base name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product knowledge base.")
    @NotBlank(message = "Knowledge base name is required.")
    @Size(max = 50, message = "Knowledge base name cannot exceed 50 characters.")
    private String name;

    @Schema(description = "Knowledge base bio.", example = "Build product documentation")
    @Size(max = 300, message = "Knowledge base bio cannot exceed 300 characters.")
    private String description;

    @Schema(description = "Public", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Knowledge base visibility is required.")
    private Boolean openStatus;

    @Schema(description = "Knowledge base cover.")
    @Size(max = 255, message = "Knowledge base cover Address cannot exceed 255 characters.")
    private String coverUrl;

    @Schema(description = "Create time initial admin user ID list.", example = "[1, 2]")
    private List<Long> adminUserIds;

    @Schema(description = "Create initial regular member User ID list.", example = "[3, 4]")
    private List<Long> memberUserIds;

    @Schema(description = "Template ID. Valid only when creating.", example = "1")
    @Positive(message = "Template ID must be greater than 0.")
    private Long templateId;

}
