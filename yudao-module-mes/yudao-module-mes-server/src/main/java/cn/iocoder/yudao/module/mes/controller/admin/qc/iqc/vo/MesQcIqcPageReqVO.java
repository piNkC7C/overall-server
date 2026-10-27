package cn.iocoder.yudao.module.mes.controller.admin.qc.iqc.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES incoming inspectionpage request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesQcIqcPageReqVO extends PageParam {

    @Schema(description = "Inspection code.", example = "IQC2025")
    private String code;

    @Schema(description = "Supplier ID.", example = "10")
    private Long vendorId;

    @Schema(description = "Supplierlot no.", example = "VB2025")
    private String vendorBatch;

    @Schema(description = "Product material ID.", example = "20")
    private Long itemId;

    @Schema(description = "Inspection result.", example = "1")
    private Integer checkResult;

    @Schema(description = "Inspectoruser ID.", example = "1")
    private Long inspectorUserId;

    @Schema(description = "Incoming Date")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] receiveDate;

    @Schema(description = "Inspection Date")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] inspectDate;

}
