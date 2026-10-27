package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - PMS item group response.")
@Data
public class PmsProjectGroupRespVO {

    @Schema(description = "Item group code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Group name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Key project")
    private String name;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sort;

    @Schema(description = "Group type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer type;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

    @Schema(description = "Item quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Integer projectCount;

}
