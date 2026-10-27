package cn.iocoder.yudao.module.mes.controller.admin.cal.team.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES team page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesCalTeamPageReqVO extends PageParam {

    @Schema(description = "Team code.", example = "TEAM-A")
    private String code;

    @Schema(description = "Team name.", example = "Injection")
    private String name;

    @Schema(description = "Team type.", example = "1")
    private Integer calendarType;

}
