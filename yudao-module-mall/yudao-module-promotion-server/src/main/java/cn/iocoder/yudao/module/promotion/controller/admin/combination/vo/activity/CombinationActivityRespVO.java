package cn.iocoder.yudao.module.promotion.controller.admin.combination.vo.activity;

import cn.iocoder.yudao.module.promotion.controller.admin.combination.vo.product.CombinationProductRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - group buy campaign response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CombinationActivityRespVO extends CombinationActivityBaseVO {

    @Schema(description = "Campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "22901")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Group-buy start size.", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
    private Integer userSize;

    @Schema(description = "Group buy product.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<CombinationProductRespVO> products;

    @Schema(description = "Product SPU name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "One cabbage")
    private String spuName; // 从 SPU 的 name 读取
    @Schema(description = "Product Image", requiredMode = Schema.RequiredMode.REQUIRED, example = "4096")
    private String picUrl; // 从 SPU 的 picUrl 读取
    @Schema(description = "Market price, in cents", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
    private Integer marketPrice; // 从 SPU 的 marketPrice 读取

    @Schema(description = "Group buy amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer combinationPrice; // 从 products 获取最小 price 读取

}
