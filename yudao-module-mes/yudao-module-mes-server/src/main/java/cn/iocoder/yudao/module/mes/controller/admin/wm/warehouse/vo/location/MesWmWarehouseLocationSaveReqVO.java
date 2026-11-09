package cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo.location;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 库区新增/修改 Request VO")
@Data
public class MesWmWarehouseLocationSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "库区编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "L001")
    @NotEmpty(message = "Zone code is required.")
    private String code;

    @Schema(description = "库区名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw-material zone")
    @NotEmpty(message = "Zone name is required.")
    private String name;

    @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Warehouse is required.")
    private Long warehouseId;

    @Schema(description = "面积", example = "500.00")
    private BigDecimal area;

    @Schema(description = "是否冻结", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Is not freeze is required.")
    private Boolean frozen;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

    }
