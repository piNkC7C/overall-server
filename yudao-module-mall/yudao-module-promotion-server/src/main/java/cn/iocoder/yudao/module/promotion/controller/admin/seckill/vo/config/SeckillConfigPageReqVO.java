package cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.config;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - Flash-sale slotpage request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SeckillConfigPageReqVO extends PageParam {

    @Schema(description = "Flash-sale slot name.", example = "Morning session")
    private String name;

    @Schema(description = "Status.", example = "0")
    private Integer status;

}
