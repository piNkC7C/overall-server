package cn.iocoder.yudao.module.system.controller.admin.user.vo.user;

import cn.hutool.core.util.ObjectUtil;
import cn.iocoder.yudao.framework.common.validation.Mobile;
import cn.iocoder.yudao.module.system.framework.operatelog.core.DeptParseFunction;
import cn.iocoder.yudao.module.system.framework.operatelog.core.PostParseFunction;
import cn.iocoder.yudao.module.system.framework.operatelog.core.SexParseFunction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Schema(description = "Admin - user create or update request.")
@Data
public class UserSaveReqVO {

    @Schema(description = "User ID.", example = "1024")
    private Long id;

    @Schema(description = "Username.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    @NotBlank(message = "Username is required.")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,30}$", message = "Username must contain only letters and numbers.")
    @Size(min = 4, max = 30, message = "Username must be 4-30 characters.")
    @DiffLogField(name = "Username.")
    private String username;

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @Size(max = 30, message = "Nickname cannot exceed 30 characters.")
    @DiffLogField(name = "Nickname")
    private String nickname;

    @Schema(description = "Notes.", example = "I am a user.")
    @DiffLogField(name = "Notes.")
    private String remark;

    @Schema(description = "Department code.", example = "I am a user.")
    @DiffLogField(name = "Department.", function = DeptParseFunction.NAME)
    private Long deptId;

    @Schema(description = "Post ID list.", example = "1")
    @DiffLogField(name = "Post.", function = PostParseFunction.NAME)
    private Set<Long> postIds;

    @Schema(description = "User email.", example = "yudao@iocoder.cn")
    @Email(message = "Email format is invalid.")
    @Size(max = 50, message = "Email length cannot exceed 50 characters.")
    @DiffLogField(name = "User email.")
    private String email;

    @Schema(description = "Mobile Number", example = "15601691300")
    @Mobile
    @DiffLogField(name = "Mobile Number")
    private String mobile;

    @Schema(description = "User gender. See SexEnum.", example = "1")
    @DiffLogField(name = "User gender.", function = SexParseFunction.NAME)
    private Integer sex;

    @Schema(description = "User avatar.", example = "https://www.iocoder.cn/xxx.png")
    @DiffLogField(name = "User avatar.")
    private String avatar;

    // ========== 仅【创建】时，需要传递的字段 ==========

    @Schema(description = "Password.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    @Length(min = 4, max = 16, message = "Password must be 4-16 characters.")
    private String password;

    @AssertTrue(message = "Password is required.")
    @JsonIgnore
    public boolean isPasswordValid() {
        return id != null // 修改时，不需要传递
                || (ObjectUtil.isAllNotEmpty(password)); // 新增时，必须都传递 password
    }

}
