package cn.iocoder.yudao.module.pms.controller.admin.kb.library.vo.member;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.kb.library.PmsKnowledgeLibraryMemberLevelEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS update knowledge base member list request.")
@Data
public class PmsKnowledgeLibraryUpdateMemberListReqVO {

    @Schema(description = "Knowledge base code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Knowledge base code is required.")
    private Long libraryId;

    @Schema(description = "Member list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotNull(message = "Member list is required.")
    private List<Member> members;

    @Schema(description = "Admin - PMS knowledge base member update item.")
    @Data
    public static class Member {

        @Schema(description = "User ID.", example = "1")
        private Long userId;

        @Schema(description = "Department code.", example = "100")
        private Long deptId;

        @Schema(description = "Member level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
        @NotNull(message = "Member level is required.")
        @InEnum(PmsKnowledgeLibraryMemberLevelEnum.class)
        private Integer level;

        @AssertTrue(message = "Knowledge base member must and can only select user or department.")
        @JsonIgnore
        public boolean isUserOrDeptValid() {
            return (userId != null && deptId == null) || (userId == null && deptId != null);
        }

    }

}
