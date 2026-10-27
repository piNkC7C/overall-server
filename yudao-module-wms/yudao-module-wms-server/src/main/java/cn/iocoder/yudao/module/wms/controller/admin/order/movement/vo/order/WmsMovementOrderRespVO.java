package cn.iocoder.yudao.module.wms.controller.admin.order.movement.vo.order;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.wms.controller.admin.order.movement.vo.detail.WmsMovementOrderDetailRespVO;
import cn.iocoder.yudao.module.wms.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - WMS warehouse transfer order response.")
@Data
@ExcelIgnoreUnannotated
public class WmsMovementOrderRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Warehouse transfer order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "YK202605110001")
    @ExcelProperty("Transfer No")
    private String no;

    @Schema(description = "Document Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Document Date")
    private LocalDateTime orderTime;

    @Schema(description = "Warehouse transfer status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Transfer Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.ORDER_STATUS)
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Source warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long sourceWarehouseId;

    @Schema(description = "Source warehouse name.", example = "Beijing warehouse")
    @ExcelProperty("Source Warehouse")
    private String sourceWarehouseName;

    @Schema(description = "Target warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long targetWarehouseId;

    @Schema(description = "Target warehouse name.", example = "Shanghai warehouse")
    @ExcelProperty("Target Warehouse")
    private String targetWarehouseName;

    @Schema(description = "Warehouse transfer quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @ExcelProperty("Transfer Quantity")
    private BigDecimal totalQuantity;

    @Schema(description = "Total amount.", example = "1000.00")
    @ExcelProperty("Total Amount")
    private BigDecimal totalPrice;

    @Schema(description = "Warehouse transfer detail.")
    private List<WmsMovementOrderDetailRespVO> details;

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
