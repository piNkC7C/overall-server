package cn.iocoder.yudao.module.system.controller.admin.notify.vo.message;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - inbox message page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NotifyMessagePageReqVO extends PageParam {

    @Schema(description = "User ID.", example = "25025")
    private Long userId;

    @Schema(description = "User type.", example = "1")
    private Integer userType;

    @Schema(description = "Template code.", example = "test_01")
    private String templateCode;

    @Schema(description = "Template type.", example = "2")
    private Integer templateType;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
