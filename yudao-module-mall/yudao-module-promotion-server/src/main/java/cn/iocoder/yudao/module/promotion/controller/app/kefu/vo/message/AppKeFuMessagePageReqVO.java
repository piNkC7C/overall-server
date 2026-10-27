package cn.iocoder.yudao.module.promotion.controller.app.kefu.vo.message;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Support message request VO.")
@Data
public class AppKeFuMessagePageReqVO {

    private static final Integer LIMIT = 10;

    @Schema(description = "Conversation code.", example = "12580")
    private Long conversationId;

    @Schema(description = "Send time.", example = "2024-03-27 12:00:00")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime createTime;

    @Schema(description = "Page size. Max 100.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Page size cannot be empty.")
    @Min(value = 1, message = "Page size minimum is 1.")
    @Max(value = 200, message = "Each TimessearchMax is 200.")
    private Integer limit = LIMIT;

}