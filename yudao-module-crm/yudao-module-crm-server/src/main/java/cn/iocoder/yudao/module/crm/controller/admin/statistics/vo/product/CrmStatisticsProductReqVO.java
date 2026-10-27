package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.product;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Product analysis request VO.")
@Data
public class CrmStatisticsProductReqVO {

    @Schema(description = "Department id.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Department id is required.")
    private Long deptId;

    @Schema(description = "Owner person user id.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "Owner user IDs", hidden = true, example = "2")
    private List<Long> userIds;

    @Schema(description = "Time range.", requiredMode = Schema.RequiredMode.REQUIRED)
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @NotEmpty(message = "Select time range.")
    @Size(min = 2, max = 2, message = "Select time range.")
    private LocalDateTime[] times;

    @Schema(description = "Product category code.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "10")
    private Long categoryId;

    @Schema(description = "Product category IDs.", hidden = true, example = "10")
    private List<Long> categoryIds;

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "20")
    private Long productId;

}
