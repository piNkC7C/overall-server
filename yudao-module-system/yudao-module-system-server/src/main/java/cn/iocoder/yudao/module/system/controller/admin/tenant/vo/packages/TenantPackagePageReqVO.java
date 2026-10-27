package cn.iocoder.yudao.module.system.controller.admin.tenant.vo.packages;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - tenant plan page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TenantPackagePageReqVO extends PageParam {

    @Schema(description = "Plan name", example = "VIP")
    private String name;

    @Schema(description = "Status.", example = "1")
    private Integer status;

    @Schema(description = "Notes.", example = "OK")
    private String remark;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "Create time.")
    private LocalDateTime[] createTime;
}
