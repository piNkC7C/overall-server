package cn.iocoder.yudao.module.mes.controller.admin.wm.batch.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES lot control page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmBatchPageReqVO extends PageParam {

    @Schema(description = "Lot code.", example = "BATCH20250314001")
    private String code;

    @Schema(description = "Material code.", example = "1")
    private Long itemId;

    @Schema(description = "Supplier code.", example = "1")
    private Long vendorId;

    @Schema(description = "Customer code.", example = "1")
    private Long clientId;

    @Schema(description = "Sales order code.", example = "SO20250314001")
    private String salesOrderCode;

    @Schema(description = "Purchase order code.", example = "PO20250314001")
    private String purchaseOrderCode;

    @Schema(description = "Production work order code.", example = "1")
    private Long workOrderId;

    @Schema(description = "Production task code.", example = "1")
    private Long taskId;

    @Schema(description = "Workstation code.", example = "1")
    private Long workstationId;

    @Schema(description = "Tool code.", example = "1")
    private Long toolId;

    @Schema(description = "Mold code.", example = "1")
    private Long moldId;

    @Schema(description = "Production lot.", example = "LOT20250314001")
    private String lotNumber;

    @Schema(description = "Quality status.", example = "1")
    private Integer qualityStatus;

    @Schema(description = "Production date.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] produceDate;

    @Schema(description = "Expiration date.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] expireDate;

    @Schema(description = "Inbound date.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] receiptDate;

}