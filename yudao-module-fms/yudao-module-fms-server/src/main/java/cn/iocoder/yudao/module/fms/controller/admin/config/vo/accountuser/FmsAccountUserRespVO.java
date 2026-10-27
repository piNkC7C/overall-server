package cn.iocoder.yudao.module.fms.controller.admin.config.vo.accountuser;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - FMS books user response.")
@Data
public class FmsAccountUserRespVO {

    @Schema(description = "Admin user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "Nickname", example = "Overall.")
    private String nickname;

    @Schema(description = "Department name.", example = "Finance")
    private String deptName;

    @Schema(description = "Mobile Number", example = "15601691399")
    private String mobile;

    @Schema(description = "Useremail.", example = "finance@example.com")
    private String email;

    @Schema(description = "User status.", example = "0")
    private Integer status;

    @Schema(description = "Is not default books.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean defaultStatus;

    @Schema(description = "Is not books creator.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean founder;

    @Schema(description = "Member permission level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer level;

}
