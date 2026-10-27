package cn.iocoder.yudao.module.mes.controller.admin.wm.productsales.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES sales shipment page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmProductSalesPageReqVO extends PageParam {

    @Schema(description = "Outbound order no.", example = "PS2026030001")
    private String code;

    @Schema(description = "Outbound order name.", example = "Productoutbound order.")
    private String name;

    @Schema(description = "Sales order code.", example = "SO202603010001")
    private String salesOrderCode;

    @Schema(description = "Customer code.", example = "1")
    private Long clientId;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Plan shipping Date.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] shipmentDate;

}
