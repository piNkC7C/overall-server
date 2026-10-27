package cn.iocoder.yudao.module.oa.controller.admin.supply.vo.issue;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Schema(description = "Supplies return request VO.")
@Data
public class OaSupplyReturnReqVO {

    @Schema(description = "Detail code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Detail code is required.")
    private Long id;

    @Schema(description = "This return quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "This return quantity cannot be empty.")
    @Min(value = 1, message = "This return quantity cannot be less than {value}.")
    private Integer quantity;

    @Schema(description = "Return notes.", example = "Item is in good condition and returned to stock")
    @Size(max = 500, message = "Return notes cannot exceed {max} characters.")
    private String returnRemark;

}
