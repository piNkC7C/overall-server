package cn.iocoder.yudao.module.pay.controller.admin.notify.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "Callback notification response VO.")
@Data
public class PayNotifyTaskRespVO {

    @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3380")
    private Long id;

    @Schema(description = "App code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10636")
    private Long appId;

    @Schema(description = "App name.", example = "wx_pay")
    private String  appName;

    @Schema(description = "Notification type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Byte type;

    @Schema(description = "Data code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "6722")
    private Long dataId;

    @Schema(description = "Merchant order number.", example = "26697")
    private String merchantOrderId;

    @Schema(description = "Merchant refund number.", example = "26697")
    private String merchantRefundId;

    @Schema(description = "Merchant transfer number.", example = "26697")
    private String merchantTransferId;

    @Schema(description = "Notification status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Byte status;

    @Schema(description = "Next notify time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime nextNotifyTime;

    @Schema(description = "Last run time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime lastExecuteTime;

    @Schema(description = "Current Notify Count.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Byte notifyTimes;

    @Schema(description = "Max notify count.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Byte maxNotifyTimes;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime updateTime;

}
