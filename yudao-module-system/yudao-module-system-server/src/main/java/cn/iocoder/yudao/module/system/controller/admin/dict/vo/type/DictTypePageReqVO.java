package cn.iocoder.yudao.module.system.controller.admin.dict.vo.type;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - dictionary type page list request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class DictTypePageReqVO extends PageParam {

    @Schema(description = "Dictionary type name, fuzzy match.", example = "Overall.")
    private String name;

    @Schema(description = "Dictionary type, fuzzy match.", example = "sys_common_sex")
    @Size(max = 100, message = "Dictionary type type length cannot exceed 100 characters.")
    private String type;

    @Schema(description = "Display status. See CommonStatusEnum.", example = "1")
    private Integer status;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "Create time.")
    private LocalDateTime[] createTime;

}
