
package cn.iocoder.yudao.module.pay.controller.admin.notify.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Callback notification detail response VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayNotifyTaskDetailRespVO extends PayNotifyTaskRespVO {

    @Schema(description = "Callback log list.")
    private List<Log> logs;

    @Schema(description = "Admin - callback log.")
    @Data
    public static class Log {

        @Schema(description = "Log ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "8848")
        private Long id;

        @Schema(description = "Notification status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Byte status;

        @Schema(description = "Current Notify Count.", requiredMode = Schema.RequiredMode.REQUIRED)
        private Byte notifyTimes;

        @Schema(description = "HTTP response body.", requiredMode = Schema.RequiredMode.REQUIRED)
        private String response;

        @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
        private LocalDateTime createTime;

    }

}
