package cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.activity;

import cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.product.SeckillProductRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - flash sale campaign response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SeckillActivityRespVO extends SeckillActivityBaseVO {

    @Schema(description = "Flash sale campaign id.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Flash sale product.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<SeckillProductRespVO> products;

    @Schema(description = "Campaign status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Order paid amount, unit: cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "22354")
    private Integer totalPrice;

    @Schema(description = "Flash sale inventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer stock;

    @Schema(description = "Flash-sale total stock.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Integer totalStock;

    @Schema(description = "New order count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Integer orderCount;

    @Schema(description = "Payer count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Integer userCount;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    // ========== productfield ==========

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, // 从 SPU 的 name 读取
            example = "Summer Sale")
    private String spuName;
    @Schema(description = "Product main image.", requiredMode = Schema.RequiredMode.REQUIRED, // 从 SPU 的 picUrl 读取
            example = "https://www.iocoder.cn/xx.png")
    private String picUrl;
    @Schema(description = "Market price, in cents", requiredMode = Schema.RequiredMode.REQUIRED, // 从 SPU 的 marketPrice 读取
            example = "50")
    private Integer marketPrice;

    @Schema(description = "Flash sale amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer seckillPrice; // 从 products 获取最小 price 读取

}
