package cn.iocoder.yudao.module.promotion.controller.app.seckill.vo.activity;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "User App - product review page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppSeckillActivityPageReqVO extends PageParam {

    @Schema(description = "Flash sale setting code.", example = "1024")
    private Long configId;

}
