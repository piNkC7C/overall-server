package cn.iocoder.yudao.module.erp.controller.admin.stock.vo.move;

import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - ERP 库存调拨单新增/修改 Request VO")
@Data
public class ErpStockMoveSaveReqVO {

    @Schema(description = "调拨编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "11756")
    private Long id;

    @Schema(description = "客户编号", example = "3113")
    private Long customerId;

    @Schema(description = "调拨时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Transfer time is required.")
    private LocalDateTime moveTime;

    @Schema(description = "备注", example = "Sample.")
    private String remark;

    @Schema(description = "附件 URL", example = "https://www.iocoder.cn/1.doc")
    private String fileUrl;

    @Schema(description = "调拨项列表", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Transfer item list is required.")
    @Valid
    private List<Item> items;

    @Data
    public static class Item {

        @Schema(description = "调拨项编号", example = "11756")
        private Long id;

        @Schema(description = "调出仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        @NotNull(message = "Outbound warehouse ID cannot be empty.")
        private Long fromWarehouseId;

        @Schema(description = "调入仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "888")
        @NotNull(message = "Inbound warehouse ID cannot be empty.")
        private Long toWarehouseId;

        @Schema(description = "产品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        @NotNull(message = "Product code is required.")
        private Long productId;

        @Schema(description = "产品单价", example = "100.00")
        private BigDecimal productPrice;

        @Schema(description = "产品数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Product quantity is required.")
        private BigDecimal count;

        @Schema(description = "备注", example = "Sample.")
        private String remark;

        @AssertTrue(message = "Source and destination warehouses must be different.")
        @JsonIgnore
        public boolean isWarehouseValid() {
            return ObjectUtil.notEqual(fromWarehouseId, toWarehouseId);
        }

    }

}