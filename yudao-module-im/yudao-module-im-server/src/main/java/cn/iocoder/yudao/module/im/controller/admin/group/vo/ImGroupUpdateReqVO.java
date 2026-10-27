package cn.iocoder.yudao.module.im.controller.admin.group.vo;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Group update request VO.")
@Data
public class ImGroupUpdateReqVO {

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1003")
    @NotNull(message = "Group ID is required")
    private Long id;

    @Schema(description = "Group name", example = "Demo tech group")
    @Size(max = 64, message = "Group name length cannot exceed 64.")
    private String name;

    @Schema(description = "Group avatar.")
    @Size(max = 512, message = "Group avatar URL cannot exceed 512 characters.")
    private String avatar;

    @Schema(description = "Group announcement.")
    @Size(max = 2048, message = "Group announcement cannot exceed 2048 characters.")
    private String notice;

    @Schema(description = "Join requires owner or admin approval.", example = "true")
    private Boolean joinApproval;

    @AssertTrue(message = "Group name is required.")
    @JsonIgnore
    public boolean isNameValid() {
        return name == null || StrUtil.isNotBlank(name);
    }

    @AssertTrue(message = "Group avatar cannot be empty.")
    @JsonIgnore
    public boolean isAvatarValid() {
        return avatar == null || StrUtil.isNotBlank(avatar);
    }

}
