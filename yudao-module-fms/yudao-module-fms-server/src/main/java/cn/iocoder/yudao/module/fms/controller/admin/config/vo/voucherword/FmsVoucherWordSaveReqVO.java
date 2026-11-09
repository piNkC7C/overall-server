package cn.iocoder.yudao.module.fms.controller.admin.config.vo.voucherword;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * FMS 凭证字保存 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "管理后台 - FMS 凭证字保存 Request VO")
@Data
public class FmsVoucherWordSaveReqVO {

    @Schema(description = "凭证字编号", example = "1024")
    private Long id;

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "凭证字", requiredMode = Schema.RequiredMode.REQUIRED, example = "Note")
    @NotBlank(message = "Journal entry character is required.")
    @Size(max = 255, message = "Journal entry character length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "打印标题", example = "Journal Voucher")
    @Size(max = 255, message = "Print title cannot exceed 255 characters.")
    private String printTitle;

    @Schema(description = "是否默认凭证字", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Is not default journal entry character is required.")
    private Boolean defaultStatus;

}
