package cn.iocoder.yudao.module.iot.controller.admin.rule.vo.data.sink;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.enums.rule.IotDataSinkTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - IoT data flow destination page request.")
@Data
public class IotDataSinkPageReqVO extends PageParam {

    @Schema(description = "Data destination name.", example = "Sam.")
    private String name;

    @Schema(description = "Data destination status.", example = "2")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Data destination type.", example = "1")
    @InEnum(IotDataSinkTypeEnum.class)
    private Integer type;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}