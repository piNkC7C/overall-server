package cn.iocoder.yudao.module.pms.controller.admin.kb.content.vo.permission;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.kb.content.PmsKnowledgeContentLevelEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS update knowledge content collaboration permission request.")
@Data
public class PmsKnowledgeContentPermissionUpdateReqVO {

    @Schema(description = "Collaboration permission code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Collaboration permission code is required.")
    private Long id;

    @Schema(description = "Public", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Public is required.")
    private Boolean openStatus;

    @Schema(description = "Public collaboration level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @NotNull(message = "Public collaboration level is required.")
    @InEnum(PmsKnowledgeContentLevelEnum.class)
    private Integer openLevel;

    @Schema(description = "Collaborator list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotNull(message = "Collaborator list is required.")
    private List<Member> members;

    @Schema(description = "Admin - PMS knowledge content collaborator save item.")
    @Data
    public static class Member {

        @Schema(description = "User ID.", example = "1")
        private Long userId;

        @Schema(description = "Department code.", example = "100")
        private Long deptId;

        @Schema(description = "Collaboration level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
        @NotNull(message = "Collaboration level is required.")
        @InEnum(PmsKnowledgeContentLevelEnum.class)
        private Integer level;

        @AssertTrue(message = "Collaborator must and can only select user or department.")
        @JsonIgnore
        public boolean isUserOrDeptValid() {
            return (userId != null && deptId == null) || (userId == null && deptId != null);
        }

    }

}
