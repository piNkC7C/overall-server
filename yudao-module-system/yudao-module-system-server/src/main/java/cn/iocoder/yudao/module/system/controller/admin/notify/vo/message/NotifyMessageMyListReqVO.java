package cn.iocoder.yudao.module.system.controller.admin.notify.vo.message;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 我的站内信列表（按时间窗，不分页）Request VO")
@Data
public class NotifyMessageMyListReqVO {

    @Schema(description = "是否已读", example = "true")
    private Boolean readStatus;

    @Schema(description = "是否已办", example = "false")
    private Boolean processStatus;

    @Schema(description = "站内信模板类型", example = "3")
    private Integer templateType;

    @Schema(description = "站内信模板编码", example = "crm_receivable_remind")
    private String templateCode;

    @Schema(description = "创建时间（必填，跨度最长 7 天）", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "[\"2026-11-14 00:00:00\", \"2026-11-20 23:59:59\"]")
    @NotNull(message = "创建时间不能为空")
    @Size(min = 2, max = 2, message = "创建时间须包含开始与结束")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
