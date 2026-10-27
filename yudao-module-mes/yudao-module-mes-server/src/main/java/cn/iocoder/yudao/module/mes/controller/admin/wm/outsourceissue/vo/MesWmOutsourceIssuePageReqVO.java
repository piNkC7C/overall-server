package cn.iocoder.yudao.module.mes.controller.admin.wm.outsourceissue.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES subcontract issue order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmOutsourceIssuePageReqVO extends PageParam {

    @Schema(description = "Issue materials order code.", example = "WOS202603020001")
    private String code;

    @Schema(description = "Issue materials order name.", example = "Subcontract issue order 001.")
    private String name;

    @Schema(description = "SupplierID.", example = "1")
    private Long vendorId;

    @Schema(description = "Production work orderID.", example = "1")
    private Long workOrderId;

    @Schema(description = "Issue materials Date.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] issueDate;

}
