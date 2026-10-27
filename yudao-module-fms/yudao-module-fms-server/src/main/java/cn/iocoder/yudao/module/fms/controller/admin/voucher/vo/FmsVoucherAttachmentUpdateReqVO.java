package cn.iocoder.yudao.module.fms.controller.admin.voucher.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - FMS journal entryAttachmentupdate request.")
@Data
public class FmsVoucherAttachmentUpdateReqVO {

    @Schema(description = "Journal entry code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Journal entry is required.")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books is required.")
    private Long accountSetId;

    @Schema(description = "AttachmentAddressArray.")
    @Size(max = 100, message = "Journal entryAttachment cannot exceed 100.")
    private List<String> attachmentUrls;

}
