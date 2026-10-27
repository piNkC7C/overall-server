package cn.iocoder.yudao.module.system.controller.admin.dept.vo.post;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - post create or update request.")
@Data
public class PostSaveReqVO {

    @Schema(description = "Post code.", example = "1024")
    private Long id;

    @Schema(description = "Post name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Potato")
    @NotBlank(message = "Post name is required.")
    @Size(max = 50, message = "Post name length cannot exceed 50 characters.")
    private String name;

    @Schema(description = "Post code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    @NotBlank(message = "Post code is required.")
    @Size(max = 64, message = "Post code length cannot exceed 64 characters.")
    private String code;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Notes.", example = "Happy note")
    private String remark;

}