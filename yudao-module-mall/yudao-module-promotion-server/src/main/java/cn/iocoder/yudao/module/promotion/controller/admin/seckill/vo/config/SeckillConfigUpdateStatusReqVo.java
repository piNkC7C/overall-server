package cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.config;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Update slot setting status request VO.")
@Data
public class SeckillConfigUpdateStatusReqVo {

    @Schema(description = "Time-slot setting ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Time-slot setting ID cannot be empty.")
    private Long id;

    @Schema(description = "Status. See CommonStatusEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Edit status must be {value}.")
    private Integer status;

}
