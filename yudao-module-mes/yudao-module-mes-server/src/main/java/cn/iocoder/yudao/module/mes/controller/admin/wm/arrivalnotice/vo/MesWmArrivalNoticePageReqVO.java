package cn.iocoder.yudao.module.mes.controller.admin.wm.arrivalnotice.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES receiving notification order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmArrivalNoticePageReqVO extends PageParam {

    @Schema(description = "Notification order code.", example = "AN2026020001")
    private String code;

    @Schema(description = "Notification order name.", example = "Steel plate receiving.")
    private String name;

    @Schema(description = "Purchase order code.", example = "PO20260101")
    private String purchaseOrderCode;

    @Schema(description = "Supplier code.", example = "1")
    private Long vendorId;

    @Schema(description = "Receiving Date.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] arrivalDate;

    @Schema(description = "Status.", example = "0")
    private Integer status;

}
