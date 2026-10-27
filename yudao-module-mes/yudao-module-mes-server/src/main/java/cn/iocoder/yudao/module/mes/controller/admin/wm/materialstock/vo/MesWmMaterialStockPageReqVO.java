package cn.iocoder.yudao.module.mes.controller.admin.wm.materialstock.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES inventory ledgerpage request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmMaterialStockPageReqVO extends PageParam {

    /**
     * 虚拟仓过滤模式 - 排除虚拟仓
     */
    public static final String VIRTUAL_FILTER_EXCLUDE = "exclude";
    /**
     * 虚拟仓过滤模式 - 只看虚拟仓
     */
    public static final String VIRTUAL_FILTER_ONLY = "only";

    @Schema(description = "Virtual-warehouse filter mode.", example = "exclude")
    private String virtualFilter;

    @Schema(description = "Material category code.", example = "1")
    private Long itemTypeId;

    @Schema(description = "Material code.", example = "1")
    private Long itemId;

    @Schema(description = "Lot no.", example = "B20260101")
    private String batchCode;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;

    @Schema(description = "Warehouse code.", example = "1")
    private Long warehouseId;

    @Schema(description = "Zone code.", example = "1")
    private Long locationId;

    @Schema(description = "Bin code.", example = "1")
    private Long areaId;

    @Schema(description = "Supplier code.", example = "1")
    private Long vendorId;

    @Schema(description = "Is not freeze.", example = "false")
    private Boolean frozen;

}
