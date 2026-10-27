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

@Schema(description = "Admin - ERP inventory transfer order create / edit request.")
@Data
public class ErpStockMoveSaveReqVO {

    @Schema(description = "Transfer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11756")
    private Long id;

    @Schema(description = "Customer code.", example = "3113")
    private Long customerId;

    @Schema(description = "Transfer time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Transfer time is required.")
    private LocalDateTime moveTime;

    @Schema(description = "Notes.", example = "Sample.")
    private String remark;

    @Schema(description = "Attachment URL.", example = "https://www.iocoder.cn/1.doc")
    private String fileUrl;

    @Schema(description = "Transfer item list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Transfer item list is required.")
    @Valid
    private List<Item> items;

    @Data
    public static class Item {

        @Schema(description = "Transfer item code.", example = "11756")
        private Long id;

        @Schema(description = "Outbound warehouse ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        @NotNull(message = "Outbound warehouse ID cannot be empty.")
        private Long fromWarehouseId;

        @Schema(description = "Inbound warehouse ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "888")
        @NotNull(message = "Inbound warehouse ID cannot be empty.")
        private Long toWarehouseId;

        @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        @NotNull(message = "Product code is required.")
        private Long productId;

        @Schema(description = "Unit Price", example = "100.00")
        private BigDecimal productPrice;

        @Schema(description = "Product quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Product quantity is required.")
        private BigDecimal count;

        @Schema(description = "Notes.", example = "Sample.")
        private String remark;

        @AssertTrue(message = "Source and destination warehouses must be different.")
        @JsonIgnore
        public boolean isWarehouseValid() {
            return ObjectUtil.notEqual(fromWarehouseId, toWarehouseId);
        }

    }

}