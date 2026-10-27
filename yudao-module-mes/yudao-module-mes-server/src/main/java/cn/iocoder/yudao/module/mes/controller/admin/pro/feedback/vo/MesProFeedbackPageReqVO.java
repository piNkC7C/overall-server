package cn.iocoder.yudao.module.mes.controller.admin.pro.feedback.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES production work report page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesProFeedbackPageReqVO extends PageParam {

    @Schema(description = "Work-report number.", example = "FB202503")
    private String code;

    @Schema(description = "Work report type.", example = "1")
    private Integer type;

    @Schema(description = "Production work order code.", example = "1")
    private Long workOrderId;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Work report time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] feedbackTime;

    @Schema(description = "Product material code.", example = "100")
    private Long itemId;

    @Schema(description = "Work report person code.", example = "1")
    private Long feedbackUserId;

    @Schema(description = "Record person code ( creator ).", example = "1")
    private String creator;

}
