package cn.iocoder.yudao.module.im.controller.admin.group.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Group create request VO.")
@Data
public class ImGroupCreateReqVO {

    @Schema(description = "Group name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Demo tech group")
    @NotBlank(message = "Group name is required.")
    @Size(max = 64, message = "Group name length cannot exceed 64.")
    private String name;

    @Schema(description = "Initial member user IDs invited at group creation, excluding the creator.", example = "[1024, 2048]")
    private List<Long> memberUserIds;

    @Schema(description = "Whether join requires owner or admin approval. Omit for open join (false).", example = "false")
    private Boolean joinApproval;

}
