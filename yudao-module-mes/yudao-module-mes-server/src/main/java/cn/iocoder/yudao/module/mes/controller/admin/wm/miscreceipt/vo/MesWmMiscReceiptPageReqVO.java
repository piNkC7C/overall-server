package cn.iocoder.yudao.module.mes.controller.admin.wm.miscreceipt.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES miscellaneous inbound order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmMiscReceiptPageReqVO extends PageParam {

    @Schema(description = "Inbound order code.", example = "MR2026030001")
    private String code;

    @Schema(description = "Inbound order name.", example = "Material return inbound order.")
    private String name;

    @Schema(description = "Miscellaneous type.", example = "1")
    private Integer type;

    @Schema(description = "Source document code.", example = "DOC2026030001")
    private String sourceDocCode;

    @Schema(description = "Source document type.", example = "WORK_ORDER")
    private String sourceDocType;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Inbound date.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] receiptDate;

}
