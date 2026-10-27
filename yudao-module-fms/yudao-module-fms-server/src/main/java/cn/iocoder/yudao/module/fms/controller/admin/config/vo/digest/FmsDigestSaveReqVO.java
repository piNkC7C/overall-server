package cn.iocoder.yudao.module.fms.controller.admin.config.vo.digest;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * FMS 常用摘要保存 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - FMS common memosave request.")
@Data
public class FmsDigestSaveReqVO {

    @Schema(description = "Common memo ID.", example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Summary content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Buy office supplies")
    @NotBlank(message = "Summary content is required.")
    @Size(max = 500, message = "Summary content length cannot exceed 500 characters.")
    private String content;

}
