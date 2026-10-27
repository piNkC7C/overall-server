package cn.iocoder.yudao.module.mes.controller.admin.wm.productissue.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES material issue outbound order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class MesWmProductIssuePageReqVO extends PageParam {

    @Schema(description = "Material issue order code.", example = "ISSUE20250226001")
    private String code;

    @Schema(description = "Material issue order name.", example = "Production material issue.")
    private String name;

    @Schema(description = "WorkstationID.", example = "1")
    private Long workstationId;

    @Schema(description = "Production work orderID.", example = "1")
    private Long workOrderId;

    @Schema(description = "Production task ID.", example = "1")
    private Long taskId;

    @Schema(description = "CustomerID.", example = "1")
    private Long clientId;

    @Schema(description = "Status.", example = "10")
    private Integer status;

    @Schema(description = "Material issue DateRange.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] issueDate;

}
