package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.group;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.date.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Schema(description = "Admin - user group page request.")
@Data
public class BpmUserGroupPageReqVO extends PageParam {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Group Name", example = "Overall.")
    private String name;

    @Schema(description = "Status.", example = "1")
    private Integer status;

    @DateTimeFormat(pattern = DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "Create time.")
    private LocalDateTime[] createTime;

}
