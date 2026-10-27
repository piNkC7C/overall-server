package cn.iocoder.yudao.module.system.api.user.dto;

import org.dromara.core.trans.vo.VO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Schema(description = "RPC service - Admin user Response DTO.")
@Data
public class AdminUserRespDTO implements VO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex")
    private String nickname;

    @Schema(description = "Account status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status; // See CommonStatusEnum enum

    @Schema(description = "Department code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long deptId;

    @Schema(description = "Post ID list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 3]")
    private Set<Long> postIds;

    @Schema(description = "Mobile Number", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300")
    private String mobile;

    @Schema(description = "Useremail.", example = "yuandao@example.com")
    private String email;

    @Schema(description = "UserGender.", example = "1")
    private Integer sex;

    @Schema(description = "UserAvatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.png")
    private String avatar;

}
