package cn.iocoder.yudao.module.mes.controller.admin.wm.miscissue.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES miscellaneous outbound order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class MesWmMiscIssuePageReqVO extends PageParam {

    @Schema(description = "Outbound order code.", example = "MI20260302001")
    private String code;

    @Schema(description = "Outbound order name.", example = "Inventory adjust outbound.")
    private String name;

    @Schema(description = "Miscellaneous type.", example = "1")
    private Integer type;

    @Schema(description = "Source document code.", example = "DOC20260302001")
    private String sourceDocCode;

    @Schema(description = "Source document type.", example = "PURCHASE_ORDER")
    private String sourceDocType;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Outbound DateRange.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] issueDate;

}
