package cn.iocoder.yudao.module.im.controller.admin.manager.sensitiveword.vo;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - IM 敏感词新增 / 修改 Request VO")
@Data
public class ImSensitiveWordSaveReqVO {

    @Schema(description = "编号（修改时必填）", example = "1024")
    private Long id;

    @Schema(description = "敏感词", requiredMode = Schema.RequiredMode.REQUIRED, example = "Blocked Word content.")
    @NotBlank(message = "Blocked Word is required.")
    @Size(max = 64, message = "Blocked Word length cannot exceed 64.")
    private String word;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status; // See CommonStatusEnum enum class (0 Enabled / 1 Disabled )

}
