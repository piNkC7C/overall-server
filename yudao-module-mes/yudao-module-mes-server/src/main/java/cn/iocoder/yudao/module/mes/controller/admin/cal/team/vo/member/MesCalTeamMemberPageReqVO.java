package cn.iocoder.yudao.module.mes.controller.admin.cal.team.vo.member;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES team member page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesCalTeamMemberPageReqVO extends PageParam {

    @Schema(description = "Team code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "201")
    @NotNull(message = "Team code is required.")
    private Long teamId;

}
