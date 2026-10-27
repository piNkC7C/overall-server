package cn.iocoder.yudao.module.mes.controller.admin.wm.itemreceipt.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES purchase receipt page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmItemReceiptPageReqVO extends PageParam {

    @Schema(description = "Inbound order code.", example = "IR2026020001")
    private String code;

    @Schema(description = "Inbound order name.", example = "Steel plateinbound order.")
    private String name;

    @Schema(description = "Supplier code.", example = "1")
    private Long vendorId;

    @Schema(description = "Inbound date.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] receiptDate;

}
