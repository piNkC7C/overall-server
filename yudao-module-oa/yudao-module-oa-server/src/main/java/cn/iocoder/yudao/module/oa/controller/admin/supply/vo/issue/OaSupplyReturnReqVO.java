package cn.iocoder.yudao.module.oa.controller.admin.supply.vo.issue;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Schema(description = "管理后台 - 用品归还 Request VO")
@Data
public class OaSupplyReturnReqVO {

    @Schema(description = "明细编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Detail code is required.")
    private Long id;

    @Schema(description = "本次归还数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "This return quantity cannot be empty.")
    @Min(value = 1, message = "This return quantity cannot be less than {value}.")
    private Integer quantity;

    @Schema(description = "归还备注", example = "Item is in good condition and returned to stock")
    @Size(max = 500, message = "Return notes cannot exceed {max} characters.")
    private String returnRemark;

}
