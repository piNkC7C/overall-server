package cn.iocoder.yudao.module.oa.controller.admin.supply.vo.issue;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Schema(description = "Issue supplies request VO.")
@Data
public class OaSupplyIssueReqVO {

    @Schema(description = "Detail code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Detail code is required.")
    private Long id;

    @Schema(description = "Issued Qty", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Issued Qty is required.")
    @Min(value = 1, message = "Issued quantity cannot be less than {value}.")
    private Integer issuedQuantity;

    @Schema(description = "Issue notes.", example = "Issued per the request lines")
    @Size(max = 500, message = "Issue notes cannot exceed {max} characters.")
    private String issueRemark;

}
