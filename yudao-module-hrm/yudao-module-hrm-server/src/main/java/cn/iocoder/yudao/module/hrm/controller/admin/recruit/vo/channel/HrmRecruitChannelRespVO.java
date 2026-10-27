package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.channel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - HRM Recruiting Channel response.")
@Data
public class HrmRecruitChannelRespVO {

    @Schema(description = "Recruiting Channel code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Built-in.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean systemFlag;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Channel name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "LinkedIn")
    private String name;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer sort;

    @Schema(description = "Notes.", example = "Common channel")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
