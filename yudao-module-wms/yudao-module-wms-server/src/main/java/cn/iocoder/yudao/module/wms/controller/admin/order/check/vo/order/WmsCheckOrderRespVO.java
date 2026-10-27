package cn.iocoder.yudao.module.wms.controller.admin.order.check.vo.order;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.wms.controller.admin.order.check.vo.detail.WmsCheckOrderDetailRespVO;
import cn.iocoder.yudao.module.wms.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - WMS inventory count order response.")
@Data
@ExcelIgnoreUnannotated
public class WmsCheckOrderRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Inventory count order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "PK202605110001")
    @ExcelProperty("Stocktake No")
    private String no;

    @Schema(description = "Document Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Document Date")
    private LocalDateTime orderTime;

    @Schema(description = "Inventory count status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Stocktake Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.ORDER_STATUS)
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long warehouseId;

    @Schema(description = "Warehouse name.", example = "Beijing warehouse")
    @ExcelProperty("Warehouse")
    private String warehouseName;

    @Schema(description = "Gain / Loss Qty", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @ExcelProperty("Variance Quantity")
    private BigDecimal totalQuantity;

    @Schema(description = "Total book amount.", example = "1000.00")
    @ExcelProperty("Total Amount")
    private BigDecimal totalPrice;

    @Schema(description = "Actual amount.", example = "980.00")
    @ExcelProperty("Actual Amount")
    private BigDecimal actualPrice;

    @Schema(description = "Inventory count detail.")
    private List<WmsCheckOrderDetailRespVO> details;

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
