package cn.iocoder.yudao.module.mes.controller.admin.qc.rqc.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES return inspection page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesQcRqcPageReqVO extends PageParam {

    @Schema(description = "Inspection code.", example = "RQC2025")
    private String code;

    @Schema(description = "Source document type.", example = "1")
    private Integer sourceDocType;

    @Schema(description = "Source document code.", example = "RT2025")
    private String sourceDocCode;

    @Schema(description = "Product material ID.", example = "20")
    private Long itemId;

    @Schema(description = "Lot no.", example = "BATCH001")
    private String batchCode;

    @Schema(description = "Inspection result.", example = "1")
    private Integer checkResult;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Inspectoruser ID.", example = "1")
    private Long inspectorUserId;

}
