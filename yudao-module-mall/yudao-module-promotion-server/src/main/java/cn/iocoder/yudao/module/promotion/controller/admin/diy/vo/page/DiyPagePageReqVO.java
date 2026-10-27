package cn.iocoder.yudao.module.promotion.controller.admin.diy.vo.page;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - decoratepagepage request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DiyPagePageReqVO extends PageParam {

    @Schema(description = "Page Name", example = "Alex.")
    private String name;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
