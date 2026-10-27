package cn.iocoder.yudao.framework.common.biz.system.permission.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Schema(description = "RPC service - department data permission Response DTO.")
@Data
public class DeptDataPermissionRespDTO {

    @Schema(description = "Is not can ViewAll data.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean all;

    @Schema(description = "Is not can View its own data.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean self;

    @Schema(description = "Can View department ID list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 3]")
    private Set<Long> deptIds;

    public DeptDataPermissionRespDTO() {
        this.all = false;
        this.self = false;
        this.deptIds = new HashSet<>();
    }

}
