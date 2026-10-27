package cn.iocoder.yudao.module.im.controller.admin.manager.face.vo.pack;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - IM sticker packpage request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class ImFacePackPageReqVO extends PageParam {

    @Schema(description = "Sticker pack name, fuzzy match.", example = "Cat")
    private String name;

    @Schema(description = "Status.", example = "0")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status; // See CommonStatusEnum enum class

    @Schema(description = "Create time.", example = "[2026-04-01 00:00:00, 2026-04-30 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
