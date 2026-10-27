package cn.iocoder.yudao.module.pay.controller.admin.app.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - payment app info page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayAppPageReqVO extends PageParam {

    @Schema(description = "App name.", example = "Bean")
    private String name;

    @Schema(description = "App key.", example = "yudao")
    private String appKey;

    @Schema(description = "Enable status.", example = "0")
    private Integer status;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "Create time.")
    private LocalDateTime[] createTime;

}
