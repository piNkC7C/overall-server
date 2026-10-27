package cn.iocoder.yudao.module.system.controller.admin.user.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "Admin - userimport response.")
@Data
@Builder
public class UserImportRespVO {

    @Schema(description = "Create succeeded username Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> createUsernames;

    @Schema(description = "Update succeeded username Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> updateUsernames;

    @Schema(description = "Failed user import map. Key is username. Value is the failure reason.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, String> failureUsernames;

}
