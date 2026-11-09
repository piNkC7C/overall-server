package cn.iocoder.yudao.module.im.controller.admin.manager.face.vo.pack;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - IM 表情包新增 / 修改 Request VO")
@Data
public class ImFacePackSaveReqVO {

    @Schema(description = "编号（修改时必填）", example = "1024")
    private Long id;

    @Schema(description = "表情包名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Kitty")
    @NotBlank(message = "Sticker pack name cannot be empty.")
    @Size(max = 64, message = "Sticker pack name cannot exceed 64 characters.")
    private String name;

    @Schema(description = "表情包图标", example = "https://cdn.example.com/face/pack/cat.png")
    @Size(max = 512, message = "Icon length cannot exceed 512.")
    private String icon;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status; // See CommonStatusEnum enum class (0 Enabled / 1 Disabled )

}
