package cn.iocoder.yudao.module.erp.controller.admin.product.vo.unit;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - ERP product order characters create / edit request.")
@Data
public class ErpProductUnitSaveReqVO {

    @Schema(description = "Order characters code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31254")
    private Long id;

    @Schema(description = "Order characters name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotEmpty(message = "Order characters name is required.")
    private String name;

    @Schema(description = "Order characters status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Order characters status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}