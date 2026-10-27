package cn.iocoder.yudao.module.fms.controller.admin.config.vo.digest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * FMS 常用摘要 Response VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - FMS common memo response.")
@Data
public class FmsDigestRespVO {

    @Schema(description = "Common memo ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long accountSetId;

    @Schema(description = "Summary content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Buy office supplies")
    private String content;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
