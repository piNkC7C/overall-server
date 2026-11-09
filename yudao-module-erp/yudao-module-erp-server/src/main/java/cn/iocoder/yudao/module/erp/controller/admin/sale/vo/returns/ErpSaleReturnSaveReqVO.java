package cn.iocoder.yudao.module.erp.controller.admin.sale.vo.returns;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - ERP 销售退货新增/修改 Request VO")
@Data
public class ErpSaleReturnSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "17386")
    private Long id;

    @Schema(description = "结算账户编号", example = "31189")
    private Long accountId;

    @Schema(description = "销售员编号", example = "1888")
    private Long saleUserId;

    @Schema(description = "退货时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Return time is required.")
    private LocalDateTime returnTime;

    @Schema(description = "销售订单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "17386")
    @NotNull(message = "Sales order code is required.")
    private Long orderId;

    @Schema(description = "优惠率，百分比", requiredMode = Schema.RequiredMode.REQUIRED, example = "99.88")
    private BigDecimal discountPercent;

    @Schema(description = "其它金额，单位：元", example = "7127")
    private BigDecimal otherPrice;

    @Schema(description = "附件地址", example = "https://www.iocoder.cn")
    private String fileUrl;

    @Schema(description = "备注", example = "Example.")
    private String remark;

    @Schema(description = "退货清单列表")
    private List<Item> items;

    @Data
    public static class Item {

        @Schema(description = "退货项编号", example = "11756")
        private Long id;

        @Schema(description = "销售订单项编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "11756")
        @NotNull(message = "Sales order item code is required.")
        private Long orderItemId;

        @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        @NotNull(message = "Warehouse code is required.")
        private Long warehouseId;

        @Schema(description = "产品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        @NotNull(message = "Product code is required.")
        private Long productId;

        @Schema(description = "产品单位单位", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        @NotNull(message = "Product order characters order characters is required.")
        private Long productUnitId;

        @Schema(description = "产品单价", example = "100.00")
        private BigDecimal productPrice;

        @Schema(description = "产品数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Product quantity is required.")
        private BigDecimal count;

        @Schema(description = "税率，百分比", example = "99.88")
        private BigDecimal taxPercent;

        @Schema(description = "备注", example = "Sample.")
        private String remark;

    }

}