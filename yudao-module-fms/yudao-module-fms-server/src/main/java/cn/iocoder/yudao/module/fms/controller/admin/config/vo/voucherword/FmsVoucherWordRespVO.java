package cn.iocoder.yudao.module.fms.controller.admin.config.vo.voucherword;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * FMS 凭证字 Response VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - FMS journal entry character response.")
@Data
public class FmsVoucherWordRespVO {

    @Schema(description = "Journal entry character code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Journal entry character.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Note")
    private String name;

    @Schema(description = "Print title.", example = "Journal Voucher")
    private String printTitle;

    @Schema(description = "Is not default journal entry character.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean defaultStatus;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer sort;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long accountSetId;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
