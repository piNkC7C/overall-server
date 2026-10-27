package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Schema(description = "Admin - user group create or update request.")
@Data
public class BpmUserGroupSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Group Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotNull(message = "Group Name is required.")
    private String name;

    @Schema(description = "Description", example = "Overall.")
    private String description;

    @Schema(description = "Member ID list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1,2,3")
    @NotNull(message = "Member ID list is required.")
    private Set<Long> userIds;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    private Integer status;

}
