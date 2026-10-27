package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.rank;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - CRM leaderboardStats request.")
@Data
public class CrmStatisticsRankReqVO {

    @Schema(description = "Department id.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Department id is required.")
    private Long deptId;

    /**
     * userIds 目前不用前端传递，目前是方便后端通过 deptId 读取编号后，设置回来
     * <p>
     * 后续，可能会支持选择部分用户进行查询
     */
    @Schema(description = "Owner user IDs", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "2")
    private List<Long> userIds;

    @Schema(description = "Time range.", requiredMode = Schema.RequiredMode.REQUIRED)
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @NotEmpty(message = "Time range is required.")
    private LocalDateTime[] times;

}
