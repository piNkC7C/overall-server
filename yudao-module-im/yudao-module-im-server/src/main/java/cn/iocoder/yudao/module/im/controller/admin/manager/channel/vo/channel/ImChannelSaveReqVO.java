package cn.iocoder.yudao.module.im.controller.admin.manager.channel.vo.channel;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - IM 频道新增 / 修改 Request VO")
@Data
public class ImChannelSaveReqVO {

    @Schema(description = "编号（修改时必填）", example = "1024")
    private Long id;

    @Schema(description = "频道业务码；唯一", requiredMode = Schema.RequiredMode.REQUIRED, example = "system_notice")
    @NotBlank(message = "Channel code is required.")
    @Size(max = 64, message = "Channel code length cannot exceed 64.")
    @Pattern(regexp = "^[a-z][a-z0-9_]*$", message = "Channel code may contain only lowercase letters, digits, and underscores, and must start with a letter.")
    private String code;

    @Schema(description = "频道名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Systemannouncement.")
    @NotBlank(message = "Channel name is required.")
    @Size(max = 64, message = "Channel name length cannot exceed 64.")
    private String name;

    @Schema(description = "频道头像", example = "https://cdn.example.com/channel/system_notice.png")
    @Size(max = 512, message = "Avatar length cannot exceed 512.")
    private String avatar;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status; // See CommonStatusEnum enum class (0 Enabled / 1 Disabled )

}
