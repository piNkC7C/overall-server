package cn.iocoder.yudao.module.pms.controller.admin.kb.content.vo.permission;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS knowledge content collaboration permission response.")
@Data
public class PmsKnowledgeContentPermissionRespVO {

    @Schema(description = "Collaboration permission code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Knowledge base code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long libraryId;

    @Schema(description = "Public", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean openStatus;

    @Schema(description = "Public collaboration level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer openLevel;

    @Schema(description = "Creator user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long creatorUserId;

    @Schema(description = "Current user collaboration level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer currentUserLevel;

    @Schema(description = "Collaborator list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Member> members;

    @Schema(description = "Admin - PMS knowledge content collaborator response.")
    @Data
    public static class Member {

        @Schema(description = "Collaborator code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long id;

        @Schema(description = "User ID.", example = "1")
        private Long userId;

        @Schema(description = "Nickname", example = "Overall.")
        private String userName;

        @Schema(description = "Department code.", example = "100")
        private Long deptId;

        @Schema(description = "Department name.", example = "Engineering.")
        private String deptName;

        @Schema(description = "Collaboration level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
        private Integer level;

    }

}
