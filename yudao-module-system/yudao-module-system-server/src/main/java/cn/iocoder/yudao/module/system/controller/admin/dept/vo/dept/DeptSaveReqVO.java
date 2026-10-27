package cn.iocoder.yudao.module.system.controller.admin.dept.vo.dept;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - department create or update request.")
@Data
public class DeptSaveReqVO {

    @Schema(description = "Department code.", example = "1024")
    private Long id;

    @Schema(description = "Department name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotBlank(message = "Department name is required.")
    @Size(max = 30, message = "Department name length cannot exceed 30 characters.")
    private String name;

    @Schema(description = "Parent department ID.", example = "1024")
    private Long parentId;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Owner person user ID.", example = "2048")
    private Long leaderUserId;

    @Schema(description = "Phone", example = "15601691000")
    @Size(max = 11, message = "Phone length cannot exceed 11 characters.")
    private String phone;

    @Schema(description = "Email", example = "yudao@iocoder.cn")
    @Email(message = "Email format is invalid.")
    @Size(max = 50, message = "Email length cannot exceed 50 characters.")
    private String email;

    @Schema(description = "Status. See CommonStatusEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Edit status must be {value}.")
    private Integer status;

}
