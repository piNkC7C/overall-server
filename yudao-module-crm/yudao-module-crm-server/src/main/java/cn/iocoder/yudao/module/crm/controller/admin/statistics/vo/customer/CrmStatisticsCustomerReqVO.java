package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.customer;

import cn.iocoder.yudao.framework.common.enums.DateIntervalEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Employee customer-analysis request VO.")
@Data
public class CrmStatisticsCustomerReqVO {

    @Schema(description = "Department id.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Department id is required.")
    private Long deptId;

    /**
     * 负责人用户 id, 当用户为空, 则计算部门下用户
     */
    @Schema(description = "Owner person user id.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1")
    private Long userId;

    /**
     * userIds 目前不用前端传递，目前是方便后端通过 deptId 读取编号后，设置回来
     * 后续，可能会支持选择部分用户进行查询
     */
    @Schema(description = "Owner user IDs", hidden = true, example = "2")
    private List<Long> userIds;

    @Schema(description = "Time gap type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(value = DateIntervalEnum.class, message = "Time gap type, must be {value}.")
    private Integer interval;

    @Schema(description = "Time range.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Size(min = 2, max = 2, message = "Select time range.")
    private LocalDateTime[] times;

}
