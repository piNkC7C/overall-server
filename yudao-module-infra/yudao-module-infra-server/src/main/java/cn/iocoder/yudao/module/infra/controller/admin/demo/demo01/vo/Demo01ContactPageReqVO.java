package cn.iocoder.yudao.module.infra.controller.admin.demo.demo01.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - sample contact page request.")
@Data
public class Demo01ContactPageReqVO extends PageParam {

    @Schema(description = "Name.", example = "John.")
    private String name;

    @Schema(description = "Gender", example = "1")
    private Integer sex;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}