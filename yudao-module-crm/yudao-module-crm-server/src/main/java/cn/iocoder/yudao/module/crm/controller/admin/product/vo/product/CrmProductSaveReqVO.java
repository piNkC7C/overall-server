package cn.iocoder.yudao.module.crm.controller.admin.product.vo.product;

import cn.iocoder.yudao.module.crm.framework.operatelog.core.CrmProductStatusParseFunction;
import cn.iocoder.yudao.module.crm.framework.operatelog.core.CrmProductUnitParseFunction;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - CRM product create or update request.")
@Data
public class CrmProductSaveReqVO {

    @Schema(description = "Product code.", example = "20529")
    private Long id;

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Good product")
    @NotNull(message = "Product name is required.")
    @DiffLogField(name = "Product name.")
    private String name;

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12306")
    @NotNull(message = "Product code is required.")
    @DiffLogField(name = "Product code.")
    private String no;

    @Schema(description = "Order characters.", example = "2")
    @DiffLogField(name = "Order characters.", function = CrmProductUnitParseFunction.NAME)
    private int unit;

    @Schema(description = "Price", requiredMode = Schema.RequiredMode.REQUIRED, example = "8911")
    @NotNull(message = "Price is required.")
    @DiffLogField(name = "Price")
    private BigDecimal price;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Put away.")
    @NotNull(message = "Status is required.")
    @DiffLogField(name = "Status.", function = CrmProductStatusParseFunction.NAME)
    private Integer status;

    @Schema(description = "Product category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Product category code is required.")
    @DiffLogField(name = "Product category code.")
    private Long categoryId;

    @Schema(description = "ProductDescription.", example = "Looks good.")
    @DiffLogField(name = "ProductDescription.")
    private String description;

    @Schema(description = "Owner person user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31926")
    @NotNull(message = "Owner person user ID is required.")
    private Long ownerUserId;

}
