package cn.iocoder.yudao.module.erp.controller.admin.stock.vo.warehouse;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - ERP warehouse create / edit request.")
@Data
public class ErpWarehouseSaveReqVO {

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11614")
    private Long id;

    @Schema(description = "Warehouse name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotEmpty(message = "Warehouse name is required.")
    private String name;

    @Schema(description = "WarehouseAddress.", example = "Downtown Seattle")
    private String address;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Sort is required.")
    private Long sort;

    @Schema(description = "Notes.", example = "Sample.")
    private String remark;

    @Schema(description = "Owner person.", example = "Taro")
    private String principal;

    @Schema(description = "Storage Fee, in yuan.", example = "13973")
    private BigDecimal warehousePrice;

    @Schema(description = "Handling Fee, in yuan.", example = "9903")
    private BigDecimal truckagePrice;

    @Schema(description = "Enable status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Enable status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}