package cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.knowledge;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - AI knowledge base page request.")
@Data
public class AiKnowledgePageReqVO extends PageParam {

    @Schema(description = "Knowledge base name.", example = "Overall.")
    private String name;

    @Schema(description = "Is not Enabled.", example = "1")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
