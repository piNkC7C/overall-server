package cn.iocoder.yudao.module.mes.controller.admin.wm.sn.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "MES Serial number page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmSnPageReqVO extends PageParam {

    @Schema(description = "Lot UUID.", example = "550e8400-e29b-41d4-a716-446655440000")
    private String uuid;

    @Schema(description = "SN.", example = "SN20260305000001")
    private String code;

    @Schema(description = "Material code.", example = "1")
    private Long itemId;

    @Schema(description = "Lot no.", example = "BATCH001")
    private String batchCode;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
