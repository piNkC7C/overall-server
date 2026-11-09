package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.member;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.pm.project.PmsProjectMemberLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - PMS 项目成员保存 Request VO")
@Data
public class PmsProjectMemberSaveReqVO {

    @Schema(description = "项目编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Item code is required.")
    private Long projectId;

    @Schema(description = "项目成员列表", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Item member is required.")
    @Valid
    private List<Member> members;

    @Schema(description = "管理后台 - PMS 项目成员保存项")
    @Data
    public static class Member {

        @Schema(description = "后台用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Admin user ID cannot be empty.")
        private Long userId;

        @Schema(description = "成员权限级别", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
        @NotNull(message = "Member permission level is required.")
        @InEnum(PmsProjectMemberLevelEnum.class)
        private Integer level;

    }

}
