package cn.iocoder.yudao.module.system.controller.admin.user.vo.user;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;
import java.util.Set;

@Schema(description = "Admin - user info response.")
@Data
@ExcelIgnoreUnannotated
public class UserRespVO{

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("User ID")
    private Long id;

    @Schema(description = "Username.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    @ExcelProperty("User Name")
    private String username;

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @ExcelProperty("Nickname")
    private String nickname;

    @Schema(description = "Notes.", example = "I am a user.")
    private String remark;

    @Schema(description = "DepartmentID.", example = "I am a user.")
    private Long deptId;
    @Schema(description = "Department name.", example = "IT")
    @ExcelProperty("Department Name")
    private String deptName;

    @Schema(description = "Post ID list.", example = "1")
    private Set<Long> postIds;

    @Schema(description = "Useremail.", example = "yudao@iocoder.cn")
    @ExcelProperty("User Email")
    private String email;

    @Schema(description = "Mobile Number", example = "15601691300")
    @ExcelProperty("Mobile Number")
    private String mobile;

    @Schema(description = "UserGender, see SexEnum enum class.", example = "1")
    @ExcelProperty(value = "User Gender", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.USER_SEX)
    private Integer sex;

    @Schema(description = "UserAvatar.", example = "https://www.iocoder.cn/xxx.png")
    private String avatar;

    @Schema(description = "Status, see CommonStatusEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Account Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "Last login IP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "192.168.1.1")
    @ExcelProperty("Last Login IP")
    private String loginIp;

    @Schema(description = "Last sign-in time", requiredMode = Schema.RequiredMode.REQUIRED, example = "Timestamp format.")
    @ExcelProperty("Last Login Time")
    private LocalDateTime loginDate;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Timestamp format.")
    private LocalDateTime createTime;

}
