package cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - Flash-sale slotcreate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SeckillConfigCreateReqVO extends SeckillConfigBaseVO {

}
