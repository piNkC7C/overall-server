package cn.iocoder.yudao.module.pms.controller.admin.kb.library.vo.member;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - PMS knowledge base member response.")
@Data
public class PmsKnowledgeLibraryMemberRespVO {

    @Schema(description = "Member code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "User ID.", example = "1")
    private Long userId;

    @Schema(description = "UserName.", example = "Overall.")
    private String nickname;

    @Schema(description = "UserAvatar.")
    private String avatar;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Department name.", example = "Engineering.")
    private String deptName;

    @Schema(description = "Parent department code.")
    private Long parentDeptId;

    @Schema(description = "Parent department name.")
    private String parentDeptName;

    @Schema(description = "Member level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer level;

}
