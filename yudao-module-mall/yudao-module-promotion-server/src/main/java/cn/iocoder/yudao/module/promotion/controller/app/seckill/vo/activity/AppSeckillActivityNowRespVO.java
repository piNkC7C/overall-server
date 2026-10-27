package cn.iocoder.yudao.module.promotion.controller.app.seckill.vo.activity;

import cn.iocoder.yudao.module.promotion.controller.app.seckill.vo.config.AppSeckillConfigRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "User App - current flash sale campaign response.")
@Data
public class AppSeckillActivityNowRespVO {

    @Schema(description = "Flash-sale slot.", requiredMode = Schema.RequiredMode.REQUIRED)
    private AppSeckillConfigRespVO config;

    @Schema(description = "Flash sale campaignArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<AppSeckillActivityRespVO> activities;

}
