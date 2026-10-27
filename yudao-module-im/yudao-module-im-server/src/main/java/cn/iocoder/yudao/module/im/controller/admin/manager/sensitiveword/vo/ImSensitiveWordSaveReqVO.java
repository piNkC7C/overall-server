package cn.iocoder.yudao.module.im.controller.admin.manager.sensitiveword.vo;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - IM Blocked Word create / edit request.")
@Data
public class ImSensitiveWordSaveReqVO {

    @Schema(description = "ID (required when updating).", example = "1024")
    private Long id;

    @Schema(description = "Blocked Word", requiredMode = Schema.RequiredMode.REQUIRED, example = "Blocked Word content.")
    @NotBlank(message = "Blocked Word is required.")
    @Size(max = 64, message = "Blocked Word length cannot exceed 64.")
    private String word;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status; // See CommonStatusEnum enum class (0 Enabled / 1 Disabled )

}
