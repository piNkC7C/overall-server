package cn.iocoder.yudao.module.iot.controller.admin.alert.vo.recrod;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - IoT alert record page request.")
@Data
public class IotAlertRecordPageReqVO extends PageParam {

    @Schema(description = "Alert setting code.", example = "29320")
    private Long configId;

    @Schema(description = "Alert level.", example = "1")
    private Integer configLevel;

    @Schema(description = "Product code.", example = "2050")
    private Long productId;

    @Schema(description = "Device code.", example = "21727")
    private String deviceId;

    @Schema(description = "Is not process.", example = "true")
    private Boolean processStatus;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}