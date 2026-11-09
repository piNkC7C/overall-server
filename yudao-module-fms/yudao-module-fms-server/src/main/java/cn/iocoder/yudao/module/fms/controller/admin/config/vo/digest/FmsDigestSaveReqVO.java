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
@Schema(description = "管理后台 - FMS 常用摘要保存 Request VO")
@Data
public class FmsDigestSaveReqVO {

    @Schema(description = "常用摘要编号", example = "1024")
    private Long id;

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "摘要内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "Buy office supplies")
    @NotBlank(message = "Summary content is required.")
    @Size(max = 500, message = "Summary content length cannot exceed 500 characters.")
    private String content;

}
