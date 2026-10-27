package cn.iocoder.yudao.module.wms.controller.admin.order.shipment.vo.order;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.wms.controller.admin.order.shipment.vo.detail.WmsShipmentOrderDetailRespVO;
import cn.iocoder.yudao.module.wms.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - WMS outbound order response.")
@Data
@ExcelIgnoreUnannotated
public class WmsShipmentOrderRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Outbound order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "CK202605110001")
    @ExcelProperty("Outbound Order No")
    private String no;

    @Schema(description = "Outbound type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "201")
    @ExcelProperty(value = "Outbound Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.SHIPMENT_ORDER_TYPE)
    private Integer type;

    @Schema(description = "Document Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Document Date")
    private LocalDateTime orderTime;

    @Schema(description = "Outbound status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Outbound Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.ORDER_STATUS)
    private Integer status;

    @Schema(description = "Business order no.", example = "SO202605110001")
    @ExcelProperty("Business Order No")
    private String bizOrderNo;

    @Schema(description = "Customer code.", example = "1024")
    private Long merchantId;

    @Schema(description = "Customer name.", example = "A a Company.")
    @ExcelProperty("Customer")
    private String merchantName;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long warehouseId;

    @Schema(description = "Warehouse name.", example = "Beijing warehouse")
    @ExcelProperty("Warehouse")
    private String warehouseName;

    @Schema(description = "Outbound quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @ExcelProperty("Outbound Quantity")
    private BigDecimal totalQuantity;

    @Schema(description = "Total amount.", example = "1000.00")
    @ExcelProperty("Total Amount")
    private BigDecimal totalPrice;

    @Schema(description = "Outbound detail.")
    private List<WmsShipmentOrderDetailRespVO> details;

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
