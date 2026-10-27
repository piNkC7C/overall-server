package cn.iocoder.yudao.module.mes.controller.admin.pro.workorder.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES production work order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesProWorkOrderPageReqVO extends PageParam {

    @Schema(description = "Work order code.", example = "WO-001")
    private String code;

    @Schema(description = "Work order name.", example = "Production work order-A.")
    private String name;

    @Schema(description = "Work order type.", example = "1")
    private Integer type;

    @Schema(description = "Source document code.", example = "SO-001")
    private String orderSourceCode;

    @Schema(description = "Product code.", example = "100")
    private Long productId;

    @Schema(description = "Customer code.", example = "300")
    private Long clientId;

    @Schema(description = "Work order status.", example = "1")
    private Integer status;

    @Schema(description = "Need-by Date")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] requestDate;

}
