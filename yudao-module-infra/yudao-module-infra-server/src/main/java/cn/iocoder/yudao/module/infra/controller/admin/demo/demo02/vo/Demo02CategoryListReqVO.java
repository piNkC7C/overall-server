package cn.iocoder.yudao.module.infra.controller.admin.demo.demo02.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - sample category list request.")
@Data
public class Demo02CategoryListReqVO {

    @Schema(description = "Name.", example = "Overall.")
    private String name;

    @Schema(description = "Parent code.", example = "6080")
    private Long parentId;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}