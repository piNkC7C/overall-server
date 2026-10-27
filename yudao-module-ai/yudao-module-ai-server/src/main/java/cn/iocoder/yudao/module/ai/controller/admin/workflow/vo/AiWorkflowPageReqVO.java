package cn.iocoder.yudao.module.ai.controller.admin.workflow.vo;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - AI workflowpage request.")
@Data
public class AiWorkflowPageReqVO extends PageParam {

    @Schema(description = "Name.", example = "Workflow")
    private String name;

    @Schema(description = "Key.", example = "FLOW")
    private String code;

    @Schema(description = "Status.", example = "1")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
