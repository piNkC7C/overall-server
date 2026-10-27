package cn.iocoder.yudao.module.trade.controller.app.aftersale.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Schema(description = "User App - trade after-sales page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppAfterSalePageReqVO extends PageParam {

    @Schema(description = "After-sales status.", example = "10, 20")
    private Set<Integer> statuses;

}
