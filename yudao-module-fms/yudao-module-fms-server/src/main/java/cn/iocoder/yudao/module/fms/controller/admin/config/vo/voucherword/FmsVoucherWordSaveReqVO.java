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
@Schema(description = "Admin - FMS journal entry character save request.")
@Data
public class FmsVoucherWordSaveReqVO {

    @Schema(description = "Journal entry character code.", example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Journal entry character.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Note")
    @NotBlank(message = "Journal entry character is required.")
    @Size(max = 255, message = "Journal entry character length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "Print title.", example = "Journal Voucher")
    @Size(max = 255, message = "Print title cannot exceed 255 characters.")
    private String printTitle;

    @Schema(description = "Is not default journal entry character.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Is not default journal entry character is required.")
    private Boolean defaultStatus;

}
