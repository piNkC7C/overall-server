package cn.iocoder.yudao.module.oa.controller.admin.supply.vo.issue;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Schema(description = "管理后台 - 用品发放 Request VO")
@Data
public class OaSupplyIssueReqVO {

    @Schema(description = "明细编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Detail code is required.")
    private Long id;

    @Schema(description = "实发数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Issued Qty is required.")
    @Min(value = 1, message = "Issued quantity cannot be less than {value}.")
    private Integer issuedQuantity;

    @Schema(description = "发放备注", example = "Issued per the request lines")
    @Size(max = 500, message = "Issue notes cannot exceed {max} characters.")
    private String issueRemark;

}
