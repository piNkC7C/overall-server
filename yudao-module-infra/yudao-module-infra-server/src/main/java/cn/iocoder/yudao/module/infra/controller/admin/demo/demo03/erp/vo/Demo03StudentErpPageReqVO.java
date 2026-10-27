package cn.iocoder.yudao.module.infra.controller.admin.demo.demo03.erp.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - studentpage request.")
@Data
public class Demo03StudentErpPageReqVO extends PageParam {

    @Schema(description = "Name.", example = "Overall.")
    private String name;

    @Schema(description = "Gender")
    private Integer sex;

    @Schema(description = "Bio.", example = "Sample.")
    private String description;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}