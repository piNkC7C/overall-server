package cn.iocoder.yudao.module.im.controller.admin.manager.face.vo.pack;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - IM sticker packcreate / update request.")
@Data
public class ImFacePackSaveReqVO {

    @Schema(description = "ID (required when updating).", example = "1024")
    private Long id;

    @Schema(description = "Sticker pack name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Kitty")
    @NotBlank(message = "Sticker pack name cannot be empty.")
    @Size(max = 64, message = "Sticker pack name cannot exceed 64 characters.")
    private String name;

    @Schema(description = "Sticker packIcon.", example = "https://cdn.example.com/face/pack/cat.png")
    @Size(max = 512, message = "Icon length cannot exceed 512.")
    private String icon;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status; // See CommonStatusEnum enum class (0 Enabled / 1 Disabled )

}
