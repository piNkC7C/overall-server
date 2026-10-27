package cn.iocoder.yudao.module.system.controller.admin.permission.vo.role;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - role create or update request.")
@Data
public class RoleSaveReqVO {

    @Schema(description = "Role code.", example = "1")
    private Long id;

    @Schema(description = "Role name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Admin.")
    @NotBlank(message = "Role name is required.")
    @Size(max = 30, message = "Role name length cannot exceed 30 characters.")
    @DiffLogField(name = "Role name.")
    private String name;

    @NotBlank(message = "Role key cannot be empty.")
    @Size(max = 100, message = "Role key cannot exceed 100 characters.")
    @Schema(description = "Role key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ADMIN")
    @DiffLogField(name = "Role Code")
    private String code;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Sort is required.")
    @DiffLogField(name = "Sort")
    private Integer sort;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @DiffLogField(name = "Status.")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status;

    @Schema(description = "Notes.", example = "Me is one role.")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    @DiffLogField(name = "Notes.")
    private String remark;

}
