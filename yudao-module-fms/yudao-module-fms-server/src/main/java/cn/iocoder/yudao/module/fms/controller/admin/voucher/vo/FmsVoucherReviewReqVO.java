package cn.iocoder.yudao.module.fms.controller.admin.voucher.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.fms.enums.voucher.FmsVoucherStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - FMS journal entry approval request.")
@Data
public class FmsVoucherReviewReqVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books is required.")
    private Long accountSetId;

    @Schema(description = "Journal entry ID list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Journal entry code is required.")
    private List<Long> ids;

    @Schema(description = "Approval status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Approval status is required.")
    @InEnum(FmsVoucherStatusEnum.class)
    private Integer status;

}
