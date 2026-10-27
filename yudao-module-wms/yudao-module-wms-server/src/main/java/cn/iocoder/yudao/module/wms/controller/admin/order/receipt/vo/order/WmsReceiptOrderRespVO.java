package cn.iocoder.yudao.module.wms.controller.admin.order.receipt.vo.order;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.wms.controller.admin.order.receipt.vo.detail.WmsReceiptOrderDetailRespVO;
import cn.iocoder.yudao.module.wms.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - WMS inbound order response.")
@Data
@ExcelIgnoreUnannotated
public class WmsReceiptOrderRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Inbound order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "RK202605110001")
    @ExcelProperty("Inbound Order No")
    private String no;

    @Schema(description = "Inbound type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "101")
    @ExcelProperty(value = "Inbound Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.RECEIPT_ORDER_TYPE)
    private Integer type;

    @Schema(description = "Document Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Document Date")
    private LocalDateTime orderTime;

    @Schema(description = "Inbound status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Inbound Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.ORDER_STATUS)
    private Integer status;

    @Schema(description = "Business order no.", example = "PO202605110001")
    @ExcelProperty("Business Order No")
    private String bizOrderNo;

    @Schema(description = "Supplier code.", example = "1024")
    private Long merchantId;

    @Schema(description = "Supplier name.", example = "A a Company.")
    @ExcelProperty("Supplier")
    private String merchantName;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long warehouseId;

    @Schema(description = "Warehouse name.", example = "Beijing warehouse")
    @ExcelProperty("Warehouse")
    private String warehouseName;

    @Schema(description = "Inbound quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @ExcelProperty("Inbound Quantity")
    private BigDecimal totalQuantity;

    @Schema(description = "Total amount.", example = "1000.00")
    @ExcelProperty("Total Amount")
    private BigDecimal totalPrice;

    @Schema(description = "Inbound detail.")
    private List<WmsReceiptOrderDetailRespVO> details;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "Creator.", example = "1")
    private String creator;
    @Schema(description = "Creator name.", example = "Overall.")
    private String creatorName;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime updateTime;

    @Schema(description = "Updater.", example = "1")
    private String updater;
    @Schema(description = "Updater name.", example = "Overall.")
    private String updaterName;

}
