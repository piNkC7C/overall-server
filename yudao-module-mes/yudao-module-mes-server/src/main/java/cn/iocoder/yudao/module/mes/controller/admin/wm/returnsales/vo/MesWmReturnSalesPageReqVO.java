package cn.iocoder.yudao.module.mes.controller.admin.wm.returnsales.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - MES 销售退货相关
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - MES sales return page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class MesWmReturnSalesPageReqVO extends PageParam {

    @Schema(description = "Return order code.", example = "RS202603010001")
    private String code;

    @Schema(description = "Return order name.", example = "Sales return.")
    private String name;

    @Schema(description = "Sales order code.", example = "SO202603010001")
    private String salesOrderCode;

    @Schema(description = "Customer ID.", example = "1")
    private Long clientId;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Return Date.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] returnDate;

}
