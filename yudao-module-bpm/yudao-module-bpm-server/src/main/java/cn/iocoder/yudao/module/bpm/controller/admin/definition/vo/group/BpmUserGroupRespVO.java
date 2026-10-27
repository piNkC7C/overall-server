package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Schema(description = "Admin - user group response.")
@Data
public class BpmUserGroupRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Group Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

    @Schema(description = "Description", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String description;

    @Schema(description = "Member ID list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1,2,3")
    private Set<Long> userIds;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
