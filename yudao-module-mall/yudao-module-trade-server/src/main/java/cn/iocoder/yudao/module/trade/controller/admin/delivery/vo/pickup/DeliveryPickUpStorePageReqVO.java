package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.pickup;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - Pickup Store page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DeliveryPickUpStorePageReqVO extends PageParam {

    @Schema(description = "Store Name", example = "Jane.")
    private String name;

    @Schema(description = "Store Phone")
    private String phone;

    @Schema(description = "Region code.", example = "18733")
    private Integer areaId;

    @Schema(description = "Store Status", example = "1")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
