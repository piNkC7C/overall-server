package cn.iocoder.yudao.module.erp.controller.admin.stock.vo.warehouse;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - ERP 仓库新增/修改 Request VO")
@Data
public class ErpWarehouseSaveReqVO {

    @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "11614")
    private Long id;

    @Schema(description = "仓库名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotEmpty(message = "Warehouse name is required.")
    private String name;

    @Schema(description = "仓库地址", example = "Downtown Seattle")
    private String address;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Sort is required.")
    private Long sort;

    @Schema(description = "备注", example = "Sample.")
    private String remark;

    @Schema(description = "负责人", example = "Taro")
    private String principal;

    @Schema(description = "仓储费，单位：元", example = "13973")
    private BigDecimal warehousePrice;

    @Schema(description = "搬运费，单位：元", example = "9903")
    private BigDecimal truckagePrice;

    @Schema(description = "开启状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Enable status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}