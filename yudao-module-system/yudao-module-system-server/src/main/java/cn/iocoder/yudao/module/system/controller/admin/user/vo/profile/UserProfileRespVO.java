package cn.iocoder.yudao.module.system.controller.admin.user.vo.profile;

import cn.iocoder.yudao.module.system.controller.admin.dept.vo.dept.DeptSimpleRespVO;
import cn.iocoder.yudao.module.system.controller.admin.dept.vo.post.PostSimpleRespVO;
import cn.iocoder.yudao.module.system.controller.admin.permission.vo.role.RoleSimpleRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(description = "User profile info response VO.")
public class UserProfileRespVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Username.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    private String username;

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String nickname;

    @Schema(description = "Useremail.", example = "yudao@iocoder.cn")
    private String email;

    @Schema(description = "Mobile Number", example = "15601691300")
    private String mobile;

    @Schema(description = "UserGender, see SexEnum enum class.", example = "1")
    private Integer sex;

    @Schema(description = "UserAvatar.", example = "https://www.iocoder.cn/xxx.png")
    private String avatar;

    @Schema(description = "Last login IP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "192.168.1.1")
    private String loginIp;

    @Schema(description = "Last sign-in time", requiredMode = Schema.RequiredMode.REQUIRED, example = "Timestamp format.")
    private LocalDateTime loginDate;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Timestamp format.")
    private LocalDateTime createTime;

    /**
     * 所属角色
     */
    private List<RoleSimpleRespVO> roles;
    /**
     * 所在部门
     */
    private DeptSimpleRespVO dept;
    /**
     * 所属岗位数组
     */
    private List<PostSimpleRespVO> posts;

}
