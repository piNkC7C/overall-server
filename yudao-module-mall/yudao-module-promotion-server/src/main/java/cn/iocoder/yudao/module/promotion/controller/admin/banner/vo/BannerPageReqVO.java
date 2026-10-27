package cn.iocoder.yudao.module.promotion.controller.admin.banner.vo;

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

@Schema(description = "Admin - Banner page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BannerPageReqVO extends PageParam {

    @Schema(description = "Title.", example = "This is a title")
    private String title;

    @Schema(description = "Status.", example = "1")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "Create time.")
    private LocalDateTime[] createTime;

}
