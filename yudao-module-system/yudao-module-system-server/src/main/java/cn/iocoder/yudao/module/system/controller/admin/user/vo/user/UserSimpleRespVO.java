package cn.iocoder.yudao.module.system.controller.admin.user.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Admin - user simple info response.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSimpleRespVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String nickname;

    @Schema(description = "Avatar")
    private String avatar;
    @Schema(description = "Gender", example = "1")
    private Integer sex;

    @Schema(description = "DepartmentID.", example = "I am a user.")
    private Long deptId;
    @Schema(description = "Department name.", example = "IT")
    private String deptName;

}
