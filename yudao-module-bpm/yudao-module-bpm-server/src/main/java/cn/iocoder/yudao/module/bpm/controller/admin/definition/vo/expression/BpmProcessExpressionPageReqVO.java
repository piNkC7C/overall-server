package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.expression;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - BPM workflow expression page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmProcessExpressionPageReqVO extends PageParam {

    @Schema(description = "Expression name.", example = "Jane.")
    private String name;

    @Schema(description = "Expression status.", example = "1")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}