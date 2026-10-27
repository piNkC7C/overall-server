package cn.iocoder.yudao.module.mes.controller.admin.qc.ipqc.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "MES in-process inspection page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesQcIpqcPageReqVO extends PageParam {

    @Schema(description = "Inspection code.", example = "IPQC2025")
    private String code;

    @Schema(description = "IPQC inspection type.", example = "1")
    private Integer type;

    @Schema(description = "Production work order ID.", example = "10")
    private Long workOrderId;

    @Schema(description = "Product material ID.", example = "50")
    private Long itemId;

    @Schema(description = "Inspection result.", example = "1")
    private Integer checkResult;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Inspectoruser ID.", example = "1")
    private Long inspectorUserId;

}
