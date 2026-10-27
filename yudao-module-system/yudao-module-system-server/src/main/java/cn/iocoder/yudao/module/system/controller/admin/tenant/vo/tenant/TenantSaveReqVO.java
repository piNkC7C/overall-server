package cn.iocoder.yudao.module.system.controller.admin.tenant.vo.tenant;

import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - tenant create or update request.")
@Data
public class TenantSaveReqVO {

    @Schema(description = "Tenant code.", example = "1024")
    private Long id;

    @Schema(description = "Tenant name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotNull(message = "Tenant name is required.")
    private String name;

    @Schema(description = "Contact.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotNull(message = "Contact is required.")
    private String contactName;

    @Schema(description = "Contact mobile", example = "15601691300")
    private String contactMobile;

    @Schema(description = "Tenant status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Tenant status.")
    private Integer status;

    @Schema(description = "Bound websites", example = "https://www.iocoder.cn")
    private List<String> websites;

    @Schema(description = "Tenant plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Tenant plan code is required.")
    private Long packageId;

    @Schema(description = "Expires at", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Expires at is required.")
    private LocalDateTime expireTime;

    @Schema(description = "Account quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Account quantity is required.")
    private Integer accountCount;

    // ========== 仅【创建】时，需要传递的字段 ==========

    @Schema(description = "Username.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,30}$", message = "Username by digits 、 letters consist of.")
    @Size(min = 4, max = 30, message = "Username must be 4-30 characters.")
    private String username;

    @Schema(description = "Password.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    @Length(min = 4, max = 16, message = "Password must be 4-16 characters.")
    private String password;

    @AssertTrue(message = "Username 、 password is required.")
    @JsonIgnore
    public boolean isUsernameValid() {
        return id != null // 修改时，不需要传递
                || (ObjectUtil.isAllNotEmpty(username, password)); // 新增时，必须都传递 username、password
    }

}
