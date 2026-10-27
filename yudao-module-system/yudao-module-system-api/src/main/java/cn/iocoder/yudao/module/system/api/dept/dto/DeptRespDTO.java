package cn.iocoder.yudao.module.system.api.dept.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "RPC service - department Response DTO.")
@Data
public class DeptRespDTO {

    @Schema(description = "Department code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Department name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Engineering.")
    private String name;

    @Schema(description = "Parent department code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long parentId;

    @Schema(description = "Owner person user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long leaderUserId;

    @Schema(description = "Department status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status; // See CommonStatusEnum enum

}
