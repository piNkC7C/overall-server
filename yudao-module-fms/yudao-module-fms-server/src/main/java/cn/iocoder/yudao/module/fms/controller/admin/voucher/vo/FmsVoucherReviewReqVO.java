package cn.iocoder.yudao.module.fms.controller.admin.voucher.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.fms.enums.voucher.FmsVoucherStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - FMS 凭证审核 Request VO")
@Data
public class FmsVoucherReviewReqVO {

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books is required.")
    private Long accountSetId;

    @Schema(description = "凭证编号数组", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Journal entry code is required.")
    private List<Long> ids;

    @Schema(description = "审核状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Approval status is required.")
    @InEnum(FmsVoucherStatusEnum.class)
    private Integer status;

}
