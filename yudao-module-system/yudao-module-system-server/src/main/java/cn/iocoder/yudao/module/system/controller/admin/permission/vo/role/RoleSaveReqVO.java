package cn.iocoder.yudao.module.system.controller.admin.permission.vo.role;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - 角色创建/更新 Request VO")
@Data
public class RoleSaveReqVO {

    @Schema(description = "角色编号", example = "1")
    private Long id;

    @Schema(description = "角色名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Admin.")
    @NotBlank(message = "Role name is required.")
    @Size(max = 30, message = "Role name length cannot exceed 30 characters.")
    @DiffLogField(name = "角色名称")
    private String name;

    @NotBlank(message = "Role key cannot be empty.")
    @Size(max = 100, message = "Role key cannot exceed 100 characters.")
    @Schema(description = "角色标志", requiredMode = Schema.RequiredMode.REQUIRED, example = "ADMIN")
    @DiffLogField(name = "角色标志")
    private String code;

    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Sort is required.")
    @DiffLogField(name = "显示顺序")
    private Integer sort;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @DiffLogField(name = "状态")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status;

    @Schema(description = "备注", example = "Me is one role.")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    @DiffLogField(name = "备注")
    private String remark;

}
