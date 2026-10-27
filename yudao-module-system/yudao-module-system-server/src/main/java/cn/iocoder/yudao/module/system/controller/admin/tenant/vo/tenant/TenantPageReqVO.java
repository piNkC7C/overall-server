package cn.iocoder.yudao.module.system.controller.admin.tenant.vo.tenant;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - tenant page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TenantPageReqVO extends PageParam {

    @Schema(description = "Tenant name", example = "Overall.")
    private String name;

    @Schema(description = "Contact.", example = "Overall.")
    private String contactName;

    @Schema(description = "Contact mobile", example = "15601691300")
    private String contactMobile;

    @Schema(description = "Tenant status (0Normal 1 disable ).", example = "1")
    private Integer status;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "Create time.")
    private LocalDateTime[] createTime;

}
